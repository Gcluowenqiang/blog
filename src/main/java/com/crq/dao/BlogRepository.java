package com.crq.dao;

import com.crq.demo.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * BlogRepository
 *
 * @author crqyue
 * @since 2023-08-31 16:46
 */
/*JpaSpecificationExecutor 便于动态实现条件查询*/
public interface BlogRepository extends JpaRepository<Blog, Long>, JpaSpecificationExecutor<Blog> {
  @Query("select b from Blog b where b.recommend = true")
  List<Blog> findTop(Pageable pageable);

  @Query("select b from Blog b where b.title like ?1 or b.content like ?1")
  Page<Blog> findByQuery(String query, Pageable pageable);

}

