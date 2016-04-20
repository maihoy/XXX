package com.makarevich.service.front.team.converter;

import com.makarevich.converter.Converter;
import com.makarevich.dao.team.model.Team;
import com.makarevich.service.front.team.dto.TeamDTO;
import org.springframework.stereotype.Component;

/**
 * User: svetlana.voyteh
 * Date: 12.04.2016
 */
@Component
public class TeamConverter implements Converter<Team, TeamDTO> {

    public TeamDTO convertToFront(Team team){
        TeamDTO teamDTO = new TeamDTO();

        teamDTO.setId(team.getId());
        teamDTO.setName(team.getName());
        teamDTO.setShortName(team.getShortName());
        teamDTO.setNotes(team.getNotes());

        return teamDTO;
    }

    public Team convertToLocal(TeamDTO dto, Team team){
        team.setName(dto.getName());
        team.setShortName(dto.getShortName());
        team.setNotes(dto.getNotes());

        return team;
    }
}
