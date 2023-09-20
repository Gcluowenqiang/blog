package com.crq.dao;

import com.crq.demo.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * UserRepository
 *
 * @author crqyue
 * @since 2023-08-30 22:54
 */
/*继承JpaRepository,直接可以使用里面的增删改查的方法*/
public interface UserRepository extends JpaRepository<User, Long> {
  User findByUsernameAndPassword(String username, String password);
}

