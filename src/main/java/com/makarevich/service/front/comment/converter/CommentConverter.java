package com.makarevich.service.front.comment.converter;

import com.makarevich.converter.Converter;
import com.makarevich.dao.comment.CommentDao;
import com.makarevich.dao.comment.CommentDaoImpl;
import com.makarevich.dao.comment.model.Comment;
import com.makarevich.service.front.comment.dto.CommentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by j on 18.4.16.
 */
@Component
public class CommentConverter implements Converter<Comment, CommentDTO> {

        @Autowired
        private CommentDao commentDao;

        public CommentDTO convertToFront(Comment comment) {
            CommentDTO dto = new CommentDTO();
            dto.setId(comment.getId());
            dto.setText(comment.getText());
            return dto;
        }

        public Comment convertToLocal(CommentDTO commentDTO, Comment comment) {
            comment.setText(commentDTO.getText());
            return comment;
        }
    }
