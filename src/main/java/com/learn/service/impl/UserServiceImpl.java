package com.learn.service.impl;

import com.learn.entity.User;
import com.learn.exception.UserExistsException;
import com.learn.exception.UserNameNotNullException;
import com.learn.mapper.UserMapper;
import com.learn.model.ResbBody;
import com.learn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 注册
     * @param user
     * @return
     * @throws RuntimeException
     */
     public ResbBody insertUser(User user) throws RuntimeException {
      if (user.getUsername()== null || " ".equals(user.getUsername())){
          throw new UserNameNotNullException("用户名不能为空");
      }
      User dbUser = userMapper.selectOne(user);
      if (dbUser != null){
          throw new UserExistsException("用户名已存在");
      }else{
          userMapper.insert(user);
      }
      ResbBody resbBody = new ResbBody();
      resbBody.setStatuscode("201");
      resbBody.setMessage("登陆成功");
      resbBody.setData(" ");

      return resbBody;
     }




}
