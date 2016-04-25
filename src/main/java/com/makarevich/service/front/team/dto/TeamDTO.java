package com.makarevich.service.front.team.dto;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;

/**
 * User: svetlana.voyteh
 * Date: 12.04.2016
 */
public class TeamDTO {

    private Long id;
    @NotBlank
    @Size(min= 1, max = 40)
    private String name;
    @NotBlank
    @Size(min= 1, max = 27)
    private String shortName;
    @NotBlank
    @Size(min= 1, max = 350)
    private String notes;

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
}
