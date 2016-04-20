package com.makarevich.service.front.team.dto;

/**
 * User: svetlana.voyteh
 * Date: 12.04.2016
 */
public class TeamDTO {

    private Long id;
    private String name;
    private String shortName;
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
