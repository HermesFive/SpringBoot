package com.example.springboot03_demo.Service.impl;


import com.example.springboot03_demo.Dao.UserDao;
import com.example.springboot03_demo.Entity.User;
import com.example.springboot03_demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public List<User> selectUserByUsername(String username){
        return userDao.selectUserByUsername(username);
    }
}
