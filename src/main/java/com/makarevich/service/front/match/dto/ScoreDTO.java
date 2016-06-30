package com.makarevich.service.front.match.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class ScoreDTO {
    private Long id;

    private Long myTeam;

    private Long theirTeam;

    @NotNull
    @Max(40)
    private Integer myScore;

    @NotNull
    @Max(40)
    private Integer theirScore;

    private String myTeamName;

    private String theirTeamName;

    public ScoreDTO() {
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

    public Integer getMyScore() {
        return myScore;
    }

    public void setMyScore(Integer myScore) {
        this.myScore = myScore;
    }

    public Integer getTheirScore() {
        return theirScore;
    }

    public void setTheirScore(Integer theirScore) {
        this.theirScore = theirScore;
    }

    public String getMyTeamName() {        return myTeamName;    }

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
