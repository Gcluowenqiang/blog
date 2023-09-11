package com.crq.dao;

import com.crq.demo.Comment;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author limi
 * @date 2017/10/22
 */
public interface CommentRepository extends JpaRepository<Comment, Long> {


  List<Comment> findByBlogIdAndParentCommentNull(Long blogId, Sort sort);
}
