package com.shuijing.mp.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.shuijing.mp.dao.entity.User;
import com.shuijing.mp.dao.mapper.UserMapper;
import com.shuijing.mp.web.MPApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

/**
 * @author liushuijing (shuijing@shanshu.ai)
 * @date 2019/11/06
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MPApplication.class)
public class UserMpperTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void selectById() {
        Integer id = 1;
        User user = userMapper.selectById(id);
        Assert.assertNotNull(user);
        log.info(user.toString());
    }

    /**
     * SELECT id,create_time,name,email,age
     *  FROM user
     *  WHERE (id = 1);
     */
    @Test
    public void selectOne() {
        Integer id = 1;
        QueryWrapper<User> wapper = new QueryWrapper<>();
//        wapper.eq("id",1);
        wapper.lambda().eq(User::getId, 1);
        User user = userMapper.selectOne(wapper);
        Assert.assertNotNull(user);
        log.info(user.toString());
    }

    /**
     * SELECT id,create_time,name,email,age
     *  FROM user
     *  WHERE (name LIKE '%j%' AND age BETWEEN 1 AND 25 AND email IS NOT NULL);
     */
    @Test
    public void selectList() {
        Integer id = 1;
        QueryWrapper<User> wapper = new QueryWrapper<>();
//        wapper.like("name", "j").between("age", 1, 25).isNotNull("email");
        wapper.lambda().like(User::getName, "j").between(User::getAge, 1, 25).isNotNull(User::getEmail);
        List<User> userList = userMapper.selectList(wapper);
        Assert.assertNotNull(userList);
        userList.forEach(System.out::println);
    }

    /**
     * SELECT COUNT( 1 )
     *  FROM user
     *  WHERE (name LIKE '%j%' AND age BETWEEN 1 AND 25 AND email IS NOT NULL);
     */
    @Test
    public void selectCount() {
        Integer id = 1;
        QueryWrapper<User> wapper = new QueryWrapper<>();
//        wapper.like("name", "j").between("age", 1, 25).isNotNull("email");
        wapper.lambda().like(User::getName, "j").between(User::getAge, 1, 25).isNotNull(User::getEmail);
        Integer count = userMapper.selectCount(wapper);
        log.info("count: {}",count);
    }

    /**
     * SELECT id
     *  FROM user
     *  WHERE (date_format(create_time,'%Y-%m-%d')='2019-11-05' AND id IN (select id
     *  FROM user
     *  WHERE name like 'j%'));
     */
    @Test
    public void selectObjs() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.apply("date_format(create_time,'%Y-%m-%d')={0}", "2019-11-05")
                        .inSql("id", "select id from user where name like 'j%'");

        List<Object> list = userMapper.selectObjs(queryWrapper);
        list.forEach(System.out::println);
    }

    /**
     * 查询结果：字段名为 map 的 key，字段的值为 map 的 value
     *
     * SELECT id,create_time,name,email,age
     *  FROM user
     *  WHERE (name LIKE 'j%' AND ( (age < 40 OR email IS NOT NULL) ));
     */
    @Test
    public void selectMaps() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//        queryWrapper.likeRight("name", "j").and(wq -> wq.lt("age", 40).or().isNotNull("email"));
        queryWrapper.lambda().likeRight(User::getName, "j")
                        .and(wq -> wq.lt(User::getAge, 40).or().isNotNull(User::getEmail));
        List<Map<String, Object>> list = userMapper.selectMaps(queryWrapper);
        list.forEach(System.out::println);
    }
}

