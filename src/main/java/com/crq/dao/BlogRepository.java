package com.crq.dao;

import com.crq.demo.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * BlogRepository
 *
 * @author crqyue
 * @since 2023-08-31 16:46
 */
/*JpaSpecificationExecutor 便于动态实现条件查询*/
public interface BlogRepository extends JpaRepository<Blog, Long>, JpaSpecificationExecutor<Blog> {
}

