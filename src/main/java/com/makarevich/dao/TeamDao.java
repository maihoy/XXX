package com.makarevich.dao;

import com.makarevich.model.Team;

import java.util.List;

public interface TeamDao {
    Team findById(int id);
    void saveTeam(Team team);
    void deleteTeamById(int id);
    List<Team> findAllTeams();
   // Team findEmployeeBySsn(String ssn);
}
