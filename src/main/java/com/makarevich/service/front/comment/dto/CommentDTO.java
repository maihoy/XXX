package com.makarevich.service.front.comment.dto;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class CommentDTO {
    private Long id;

    @NotNull
    @Size(min = 1, max = 500)
    private String text;

    @NotNull
    private String date;

    private Long creator;

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Long getCreator() {
        return creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }
}
