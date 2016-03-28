package com.makarevich.dao;

import com.makarevich.model.Team;

import java.util.List;

public interface TeamDao {

    void saveTeam(Team team);
    void deleteTeamById(int id);
    List<Team> findAllTeams();
    Team findById(int id);
    // Team findEmployeeBySsn(String ssn);
}
