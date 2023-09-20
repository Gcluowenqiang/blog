package com.crq.dao;

import com.crq.demo.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

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


  /*
   * @Modifying 用于标识一个方法是修改数据库操作的方法，Spring Data JPA会在执行该方法时，自动创建并执行相应的SQL语句，从而完成数据库的修改操作
   * */
  @Transactional
  @Modifying
  @Query("update Blog b set b.views = b.views+1 where b.id = ?1")
  void updateViews(Long id);

  @Query("select function('date_format',b.updateTime,'%Y') as year from Blog b group by function('date_format',b.updateTime,'%Y') order by year desc ")
  List<String> findGroupYear();

  @Query("select b from Blog b where function('date_format',b.updateTime,'%Y') = ?1")
  List<Blog> findByYear(String year);

}

