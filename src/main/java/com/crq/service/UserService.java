package com.crq.service;

import com.crq.demo.User;

/**
 * UserService
 *
 * @author crqyue
 * @since 2023-08-30 22:50
 */
public interface UserService {
  User checkUser(String username, String password);
}
