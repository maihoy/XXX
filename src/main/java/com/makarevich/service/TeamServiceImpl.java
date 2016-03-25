package com.makarevich.service;

import com.makarevich.dao.TeamDao;
import com.makarevich.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("teamService")
@Transactional
public class TeamServiceImpl implements TeamService {
    @Autowired
    private TeamDao dao;

    public Team findById(int id) {
        return dao.findById(id);
    }

    public void saveTeam(Team team) {
        dao.saveTeam(team);
    }


    public void updateTeam(Team team) {
        Team entity = dao.findById(team.getId());
        if(entity!=null){
            entity.setName(team.getName());
            entity.setShortName(team.getShortName());
            entity.setNotes(team.getNotes());
        }
    }

    public void deleteTeamById(int id) {
        dao.deleteTeamById(id);
    }

    public List<Team> findAllTeams() {
        return dao.findAllTeams();
    }


}
