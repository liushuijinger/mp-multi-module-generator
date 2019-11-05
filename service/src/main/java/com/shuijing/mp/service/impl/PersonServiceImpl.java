package com.shuijing.mp.service.impl;

import com.shuijing.mp.dao.entity.Person;
import com.shuijing.mp.dao.mapper.PersonMapper;
import com.shuijing.mp.service.PersonService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liushuijing
 * @since 2019-11-05
 */
@Service
public class PersonServiceImpl extends ServiceImpl<PersonMapper, Person> implements PersonService {

}
