package com.makarevich.dao.team.model;


import javax.persistence.*;
import javax.validation.constraints.Size;


@Entity
@Table(name="TEAM")

public class Team {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "name", nullable = false)
    private String name;


    @Column(name = "short_name", nullable = true)
    private String shortName;


    @Column(name = "notes", nullable = true)
    private String notes;

    @Column(name="creator", nullable=false)
    private Long creator;

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

    public String getShortName() {  return shortName;  }

    public void setShortName(String short_name) {
        this.shortName = short_name;
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Team))
            return false;
        Team other = (Team) obj;
        if (id != other.id)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Team [id=" + id + ", name=" + name + ", shortName="
                + shortName + ", notes=" + notes+"]";
    }
}
