package com.makarevich.service.front.team.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TeamDTO {

    private Long id;
    @NotNull
    @Size(min= 1, max = 50)
    private String name;
    @NotNull
    @Size(min= 1, max = 10)
    private String shortName;
    @NotNull
    @Size(min= 1, max = 250)
    private String notes;
    private Long creator;

    public TeamDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Long getCreator() {
        return creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }
}
