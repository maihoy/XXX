package com.makarevich.dao.match.model;


import com.makarevich.dao.team.model.Team;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Match {

    private Long id;
    private Team myTeam;
    private Team theirTeam;
    private Date date;
    private List<Set> sets = new ArrayList<Set>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Team getMyTeam() {
        return myTeam;
    }

    public void setMyTeam(Team myTeam) {
        this.myTeam = myTeam;
    }

    public Team getTheirTeam() {
        return theirTeam;
    }

    public void setTheirTeam(Team theirTeam) {
        this.theirTeam = theirTeam;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Set> getSets() {
        return sets;
    }

    public void setSets(List<Set> sets) {
        this.sets = sets;
    }
}
