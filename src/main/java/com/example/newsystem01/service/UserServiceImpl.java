package com.example.newsystem01.service;

import com.example.newsystem01.Dao.UserMapper;
import com.example.newsystem01.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }


    @Override
    public User getUserByName(String name) {
        return userMapper.getUserByName(name);
    }

    @Override
//    @Transactional(rollbackFor = Exception.class)
    public Integer insertUser(User user) {
        // 插入用户信息
        userMapper.insertUser(user);
        // 手动抛出异常
        throw new RuntimeException();
    }

    @Override
    public User getUser() {
        return null;
    }


}
