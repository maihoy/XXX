package com.makarevich.service.front.comment;

import com.makarevich.dao.comment.CommentDao;
import com.makarevich.dao.comment.model.Comment;
import com.makarevich.service.front.comment.converter.CommentConverter;
import com.makarevich.service.front.comment.dto.CommentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("commentService")
@Transactional
public class CommentServiceImpl implements CommentService{

    @Autowired
    private CommentDao dao;
    @Autowired
    private CommentConverter commentConverter;

    public CommentDTO findById(Long id) {
        Comment comment = dao.findById(id);
        return commentConverter.convertToFront(comment);
    }

    public void saveComment(CommentDTO comment) {
        if (comment.getId() != null){
            Comment entity = dao.findById(comment.getId());
            dao.saveComment(commentConverter.convertToLocal(comment, entity));
        }  else {
            dao.saveComment(commentConverter.convertToLocal(comment, new Comment()));
        }
    }


    public void updateComment(CommentDTO comment) {
        Comment entity = dao.findById(comment.getId());
        if(entity!=null){
            commentConverter.convertToLocal(comment, entity);
        }
    }

    public void deleteCommentById(Long id) {
        dao.deleteCommentById(id);
    }

    public List<CommentDTO> findAllComments() {
        List<Comment> comments = dao.findAllComments();
        List<CommentDTO> result = new ArrayList<CommentDTO>(comments.size());
        for (Comment comment : comments) {
            result.add(commentConverter.convertToFront(comment));
        }
        return result;
    }

}
