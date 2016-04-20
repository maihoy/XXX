package com.makarevich.service.front.comment;

import com.makarevich.dao.comment.model.Comment;

import java.util.List;

public interface CommentService {
    Comment findById(Long id);

    void saveComment(Comment comment);

    void updateComment(Comment comment);

    void deleteCommentById(Long id);

    List<Comment> findAllComments();
}
