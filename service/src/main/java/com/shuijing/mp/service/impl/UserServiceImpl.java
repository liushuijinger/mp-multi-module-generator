package com.shuijing.mp.service.impl;

import com.shuijing.mp.dao.entity.User;
import com.shuijing.mp.dao.mapper.UserMapper;
import com.shuijing.mp.service.UserService;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
