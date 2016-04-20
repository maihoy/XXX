package com.makarevich.dao.comment;

import com.makarevich.dao.comment.model.Comment;
import java.util.List;

public interface CommentDao {

    void saveComment(Comment comment);
    void deleteCommentById(Long id);
    List<Comment> findAllComments();
    Comment findById(Long id);
}
