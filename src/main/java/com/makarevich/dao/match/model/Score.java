package com.makarevich.dao.match.model;

import com.makarevich.dao.team.model.Team;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="SCORE")
public class Score {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "my_team")
    private Team myTeam;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "their_team")
    private Team theirTeam;

    @Column(name = "my_score", nullable = false)
    private Integer myScore;

    @Column(name = "their_srore", nullable = false)
    private Integer theirScore;

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
}
