package com.makarevich.service.front.player.dto;


import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public class PlayerDTO {

    private Long id;

    @NotNull
    @Size(min= 1, max = 150)
    private String name;

    @NotNull
    @Size(min= 1, max = 150)
    private String surname;

    @NotNull
    @Email
    @Size(min= 1, max = 45)
    private String email;

    private Long team;

    private String teamName;

    public PlayerDTO() {
    }

    public Long getId() {
        return id ;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName()  {
        return name;
    }

    public void setName(String name) {

        this.name = name ;

    }

    public String getEmail (){return email;}

    public void setEmail(String email){ this.email= email;}

    public String getSurname() {        return surname;    }

    public void setSurname(String surname) {        this.surname = surname;    }

    public Long getTeam() {
        return team;
    }

    public void setTeam(Long team) {
        this.team = team;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}
