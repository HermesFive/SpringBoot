package com.example.springboot03_demo.Service;

import com.example.springboot03_demo.Entity.User;

import java.util.List;

public interface UserService {

    public List<User> selectUserByUsername(String username);

    public User login(String username,String password);

}
