package com.makarevich.service.front.match.dto;

import com.makarevich.dao.match.model.Set;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

public class MatchDTO {

    private Long id;

    private Long myTeam;

    private Long theirTeam;

    @NotNull
    private Date date;

   // private Long sets;

    private String myTeamName;

    private String theirTeamName;


    public MatchDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMyTeam() {
        return myTeam;
    }

    public void setMyTeam(Long myTeam) {
        this.myTeam = myTeam;
    }

    public Long getTheirTeam() {
        return theirTeam;
    }

    public void setTheirTeam(Long theirTeam) {
        this.theirTeam = theirTeam;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

   // public List<Set> getSets() {       return this.sets;    }

   // public void setSets(List<Set> sets) {        this.sets = sets;    }

    public String getMyTeamName() {
        return myTeamName;
    }

    public void setMyTeamName(String myTeamName) {
        this.myTeamName = myTeamName;
    }

    public String getTheirTeamName() {
        return theirTeamName;
    }

    public void setTheirTeamName(String theirTeamName) {
        this.theirTeamName = theirTeamName;
    }

}
