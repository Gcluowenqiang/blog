package com.crq.dao;

import com.crq.demo.Type;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * TypeRepository
 *
 * @author crqyue
 * @since 2023-08-31 01:09
 */
public interface TypeRepository extends JpaRepository<Type, Long> {
  Type findByName(String name);
}

