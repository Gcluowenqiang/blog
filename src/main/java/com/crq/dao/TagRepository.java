package com.crq.dao;

import com.crq.demo.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * TagRepository
 *
 * @author crqyue
 * @since 2023-08-31 14:02
 */
public interface TagRepository extends JpaRepository<Tag, Long> {
  
  Tag findByName(String name);
}

