package com.makarevich.service.front.team;


import com.makarevich.service.front.team.dto.TeamDTO;

import java.util.List;


public interface TeamService {
    TeamDTO findTeamById(Long id);

    void saveTeam(TeamDTO team);

    void updateTeam(TeamDTO team);

    void deleteTeamById(Long id);

    List<TeamDTO> findAllTeams();

    List<TeamDTO> findTeamByCreator(Long id);

}
