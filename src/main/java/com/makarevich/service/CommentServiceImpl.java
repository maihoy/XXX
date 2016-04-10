package com.makarevich.service;

import com.makarevich.dao.CommentDao;
import com.makarevich.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service("commentService")
@Transactional
public class CommentServiceImpl implements CommentService{

    @Autowired
    private CommentDao dao;

    public Comment findById(int id) {
        return dao.findById(id);
    }

    public void saveComment(Comment comment) {
        dao.saveComment(comment);
    }


    public void updateComment(Comment comment) {
        Comment entity = dao.findById(comment.getId());
        if(entity!=null){
            entity.setText(comment.getText());
        }
    }

    public void deleteCommentById(int id) {
        dao.deleteCommentById(id);
    }

    public List<Comment> findAllComments() {
        return dao.findAllComments();
    }

}
