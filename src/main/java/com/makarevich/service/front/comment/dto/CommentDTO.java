package com.makarevich.service.front.comment.dto;

/**
 * Created by j on 18.4.16.
 */
public class CommentDTO {
    private Long id;
    private String text;


    public CommentDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
