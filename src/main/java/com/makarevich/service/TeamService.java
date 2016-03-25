package com.makarevich.service;

import com.makarevich.model.Team;

import java.util.List;


public interface TeamService {
    Team findById(int id);

    void saveTeam(Team team);

    void updateTeam(Team team);

    void deleteTeamById(int id);

    List<Team> findAllTeams();

   // Team findEmployeeBySsn(String ssn);

  //  boolean isEmployeeSsnUnique(Integer id, String ssn);
}
