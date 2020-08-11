package com.learn.demo.service.impl;

import com.learn.demo.exception.UserExistsException;
import com.learn.demo.exception.UserNameNotNullException;
import com.learn.demo.service.UserService;
import com.learn.demo.entity.User;
import com.learn.demo.mapper.UserMapper;
import com.learn.demo.model.ResbBody;
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
     public ResbBody InsertUser(User user) throws RuntimeException {
      if (user.getUsername()== null || " ".equals(user.getUsername())){
          throw new UserNameNotNullException("用户名不能为空");
      }
      User dbUser = userMapper.selectOne(user);
      if (dbUser.getUsername() != null){
          throw new UserExistsException("用户名已存在");
      }else{
          userMapper.insert(user);
      }
      ResbBody resbBody = new ResbBody();
      resbBody.setStatuscode("201");
      resbBody.setMessage("注册成功");
      resbBody.setData(" ");

      return resbBody;
     }

    /**
     * 登录
     * @param user
     * @return
     * @throws RuntimeException
     */
    public ResbBody LoginUser(User user) throws RuntimeException {
        if (user.getUsername()== null || " ".equals(user.getUsername())){
            throw new UserNameNotNullException("用户名不能为空");
        }
        User dbUser = userMapper.selectOne(user);
        if (dbUser==null){
            userMapper.insert(user);
        }
        else if (!dbUser.getPassword().equals(user.getPassword())){
            throw new UserExistsException("密码错误");
        }else{
            user.setId(dbUser.getId());
        }
        ResbBody resbBody = new ResbBody();
        resbBody.setStatuscode("200");
        resbBody.setMessage("登陆成功");
        resbBody.setData(" ");
        return resbBody;
    }



}
