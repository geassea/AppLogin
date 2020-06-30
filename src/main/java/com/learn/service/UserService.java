package com.learn.service;

import com.learn.entity.User;
import com.learn.model.ResbBody;

public interface UserService {
    ResbBody insertUser(User user);

    //User findUserByUsername(String username);
}
