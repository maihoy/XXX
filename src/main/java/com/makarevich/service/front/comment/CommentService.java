package com.makarevich.service.front.comment;

import com.makarevich.service.front.comment.dto.CommentDTO;

import java.util.List;

public interface CommentService {
    CommentDTO findById(Long id);

    void saveComment(CommentDTO comment);

    void updateComment(CommentDTO comment);

    void deleteCommentById(Long id);

    List<CommentDTO> findAllComments();
}
