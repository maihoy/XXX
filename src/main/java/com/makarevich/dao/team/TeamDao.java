package com.makarevich.dao.team;

import com.makarevich.dao.team.model.Team;

import java.util.List;

public interface TeamDao {

    void saveTeam(Team team);
    void deleteTeamById(Long id);
    List<Team> findAllTeams();
    Team findById(Long id);
}
