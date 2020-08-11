package com.learn.demo.service;

import com.learn.demo.entity.User;
import com.learn.demo.model.ResbBody;

public interface UserService {
    ResbBody InsertUser(User user);
    ResbBody LoginUser(User user);
}
