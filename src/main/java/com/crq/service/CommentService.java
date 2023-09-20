package com.crq.service;

import com.crq.demo.Comment;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * CommentService
 *
 * @author crqyue
 * @since 2023-09-11 14:27
 */
public interface CommentService {
  List<Comment> listCommentByBlogId(Long blogId) throws InvocationTargetException, IllegalAccessException;

  Comment saveComment(Comment comment);
}
