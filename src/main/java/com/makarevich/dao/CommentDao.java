package com.makarevich.dao;

import com.makarevich.model.Comment;
import java.util.List;

public interface CommentDao {

    void saveComment(Comment comment);
    void deleteCommentById(int id);
    List<Comment> findAllComments();
    Comment findById(int id);
}
