package com.makarevich.service.front.comment;

import com.makarevich.dao.comment.CommentDao;
import com.makarevich.dao.comment.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service("commentService")
@Transactional
public class CommentServiceImpl implements CommentService{

    @Autowired
    private CommentDao dao;

    public Comment findById(Long id) {
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

    public void deleteCommentById(Long id) {
        dao.deleteCommentById(id);
    }

    public List<Comment> findAllComments() {
        return dao.findAllComments();
    }

}
