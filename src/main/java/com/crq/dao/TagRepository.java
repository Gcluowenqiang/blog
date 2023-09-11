package com.crq.dao;

import com.crq.demo.Tag;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * TagRepository
 *
 * @author crqyue
 * @since 2023-08-31 14:02
 */
public interface TagRepository extends JpaRepository<Tag, Long> {

  Tag findByName(String name);

  @Query("select t from Tag t")
  List<Tag> findTop(Pageable pageable);
}

