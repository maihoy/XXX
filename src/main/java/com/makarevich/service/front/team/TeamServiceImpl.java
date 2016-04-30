package com.makarevich.service.front.team;

import com.makarevich.dao.team.TeamDao;
import com.makarevich.dao.team.model.Team;
import com.makarevich.service.front.team.converter.TeamConverter;
import com.makarevich.service.front.team.dto.TeamDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("teamService")
@Transactional
public class TeamServiceImpl implements TeamService {
    @Autowired
    private TeamDao dao;
    @Autowired
    private TeamConverter teamConverter;

    public TeamDTO findById(Long id) {
        Team team = dao.findById(id);
        return teamConverter.convertToFront(team);
    }

    public void saveTeam(TeamDTO team) {
        if (team.getId() != null){
            Team entity = dao.findById(team.getId());
            dao.saveTeam(teamConverter.convertToLocal(team, entity));
        }  else {
            dao.saveTeam(teamConverter.convertToLocal(team, new Team()));
        }
    }


    public void updateTeam(TeamDTO team) {
        Team entity = dao.findById(team.getId());
        if(entity!=null){
            teamConverter.convertToLocal(team, entity);
        }
    }

    public void deleteTeamById(Long id) {
        dao.deleteTeamById(id);
    }

    public List<TeamDTO> findAllTeams() {
        List<Team> teams = dao.findAllTeams();
        List<TeamDTO> result = new ArrayList<TeamDTO>(teams.size());
        for (Team team : teams) {
            result.add(teamConverter.convertToFront(team));
        }
        return result;
    }


}
