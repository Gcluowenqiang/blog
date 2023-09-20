package com.crq.service.impl;

import com.crq.dao.UserRepository;
import com.crq.demo.User;
import com.crq.service.UserService;
import com.crq.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * UserServiceImpl
 *
 * @author crqyue
 * @since 2023-08-30 22:53
 */
@Service
public class UserServiceImpl implements UserService {
  //注入UserRepository
  @Autowired
  private UserRepository userRepository;

  /*根据姓名和密码进行查询*/
  @Override
  public User checkUser(String username, String password) {
    /*再查询的同时进行密码对比*/
    return userRepository.findByUsernameAndPassword(username, MD5Utils.code(password));
  }
}
