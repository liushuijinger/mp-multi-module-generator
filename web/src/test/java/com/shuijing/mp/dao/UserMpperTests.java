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

    @Test
    public void selectOne() {
        Integer id = 1;
        QueryWrapper<User> wapper = new QueryWrapper<>();
        wapper.eq("id",1);
        User user = userMapper.selectOne(wapper);
        Assert.assertNotNull(user);
        log.info(user.toString());
    }

    @Test
    public void selectList() {
        Integer id = 1;
        QueryWrapper<User> wapper = new QueryWrapper<>();
        wapper.like("name", "j").between("age", 1, 25).isNotNull("email");
        List<User> userList = userMapper.selectList(wapper);
        Assert.assertNotNull(userList);
        userList.forEach(System.out::println);
    }

    @Test
    public void selectCount() {
        Integer id = 1;
        QueryWrapper<User> wapper = new QueryWrapper<>();
        wapper.like("name", "j").between("age", 1, 25).isNotNull("email");
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
}

