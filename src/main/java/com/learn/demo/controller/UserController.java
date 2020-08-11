package com.learn.demo.controller;

import com.learn.demo.model.ResbBody;
import com.learn.demo.service.UserService;
import com.learn.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/log")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ResbBody insert(@RequestBody User user){
        return userService.LoginUser(user);
    }

    /*@RequestMapping(value = "/register",method = RequestMethod.POST)
    public ResbBody register(@RequestBody User user){
        ResbBody result = new ResbBody();

        if(userService.findUserByUsername(user.getUsername()) != null){
            result.setStatuscode("401");
            result.setMessage("用户名已存在");
            result.setData(" ");
            return result;
        }

        userService.insertUser(user);
        result.setStatuscode("201");
        result.setMessage("注册成功");
        result.setData("");
        return result;
    }*/


    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public ResbBody login(@RequestBody User user){
        return userService.InsertUser(user);
    }
}
