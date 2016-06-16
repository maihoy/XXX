package com.makarevich.service.front.match.converter;


import com.makarevich.converter.Converter;
import com.makarevich.dao.match.model.Match;
import com.makarevich.dao.team.TeamDao;
import com.makarevich.dao.team.model.Team;
import com.makarevich.service.front.match.dto.MatchDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MatchConverter implements Converter<Match, MatchDTO> {

    @Autowired
    private TeamDao teamDao;

    public MatchDTO convertToFront(Match match) {
        MatchDTO dto = new MatchDTO();
        dto.setId(match.getId());
        dto.setDate(match.getDate());

        Team myTeam = match.getMyTeam();
        dto.setMyTeam(myTeam.getId());
        dto.setMyTeamName(myTeam.getName());

        Team theirTeam = match.getTheirTeam();
        dto.setTheirTeam(theirTeam.getId());
        dto.setTheirTeamName(theirTeam.getName());

      //  for (  : match.getSets()) {
       //     dto.getSets().add(Converter.convertToFront(userRole));
      //  }


        return dto;
    }

    public Match convertToLocal(MatchDTO matchDTO, Match match) {
        match.setMyTeam(teamDao.findTeamById(matchDTO.getMyTeam()));
        match.setDate(matchDTO.getDate());
      //  match.setSets();
        match.setTheirTeam(teamDao.findTeamById(matchDTO.getTheirTeam()));
        return match;
    }
}
