package com.makarevich.service.front.match.converter;

import com.makarevich.converter.Converter;
import com.makarevich.dao.match.model.Match;
import com.makarevich.dao.match.model.Score;
import com.makarevich.dao.match.model.Set;
import com.makarevich.dao.team.TeamDao;
import com.makarevich.dao.team.model.Team;
import com.makarevich.service.front.match.dto.MatchDTO;
import com.makarevich.service.front.match.dto.ScoreDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ScoreConverter implements Converter<Score, ScoreDTO> {

    @Autowired
    private TeamDao teamDao;

    public ScoreDTO convertToFront(Score score) {
        ScoreDTO dto = new ScoreDTO();
        dto.setId(score.getId());
        dto.setMyScore(score.getMyScore());
        dto.setTheirScore(score.getTheirScore());

        Team myTeam = score.getMyTeam();
        dto.setMyTeam(myTeam.getId());
        dto.setMyTeamName(myTeam.getName());

        Team theirTeam = score.getTheirTeam();
        dto.setTheirTeam(theirTeam.getId());
        dto.setTheirTeamName(theirTeam.getName());

        return dto;
    }

    public Score convertToLocal(ScoreDTO scoreDTO, Score score) {
        score.setMyTeam(teamDao.findTeamById(scoreDTO.getMyTeam()));
        score.setMyScore(scoreDTO.getMyScore());
        score.setTheirTeam(teamDao.findTeamById(scoreDTO.getTheirTeam()));
        score.setTheirScore(scoreDTO.getTheirScore());
        return score;
    }
}
