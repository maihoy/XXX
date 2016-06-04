package com.makarevich.service.front.comment.dto;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CommentDTO {
    private Long id;

    @NotNull
    @Size(min = 1, max = 500)
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
