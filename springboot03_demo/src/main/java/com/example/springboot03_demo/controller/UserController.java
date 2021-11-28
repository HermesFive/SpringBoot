package com.example.springboot03_demo.controller;

import com.example.springboot03_demo.Entity.User;
import com.example.springboot03_demo.Service.UserService;
import com.example.springboot03_demo.utils.getMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(value = "http://localhost:56576", maxAge = 1800, allowedHeaders = "*")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{username}")
    @ResponseBody
    public Map<String,Object> getUserByUsername(@PathVariable String username){
        List<User> users = userService.selectUserByUsername(username);
        if (users!=null){
            return getMap.success(users);
        }else {
            return getMap.error();
        }
    }
}
