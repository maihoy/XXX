package com.makarevich.dao.match.model;


import com.makarevich.dao.team.model.Team;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="MATCH")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "myTeam")
    private Team myTeam;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "theirTeam")
    private Team theirTeam;

    @Column(name = "date", nullable = false)
    private Date date;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="set")
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
