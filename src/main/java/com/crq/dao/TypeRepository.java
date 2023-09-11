package com.crq.dao;

import com.crq.demo.Type;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * TypeRepository
 *
 * @author crqyue
 * @since 2023-08-31 01:09
 */
public interface TypeRepository extends JpaRepository<Type, Long> {
  Type findByName(String name);

  @Query("select t from Type t")
  List<Type> findTop(Pageable pageable);

}

