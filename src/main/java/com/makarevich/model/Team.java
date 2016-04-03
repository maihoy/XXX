package com.makarevich.model;


import javax.persistence.*;
import javax.validation.constraints.Size;


@Entity
@Table(name="TEAM")

public class Team {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(min=3, max=50)
    @Column(name = "name", nullable = false)
    private String name;

   // @Size(min=3, max=10)
    @Column(name = "short_name", nullable = true)
    private String shortName;

   // @Size(min=0, max=250)
    @Column(name = "notes", nullable = true)
    private String notes;


    public int getId() {
        return id;
    }

    public void setId(int id) {
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
                + shortName + ", notes=" + "]";
    }
}
