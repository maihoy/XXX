package com.makarevich.service;

import com.makarevich.model.Comment;

import java.util.List;

public interface CommentService {
    Comment findById(int id);

    void saveComment(Comment comment);

    void updateComment(Comment comment);

    void deleteCommentById(int id);

    List<Comment> findAllComments();
}
