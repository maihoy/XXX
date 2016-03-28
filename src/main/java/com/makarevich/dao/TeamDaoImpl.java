package com.makarevich.dao;

import java.util.List;

import com.makarevich.model.Team;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("teamDao")

public class TeamDaoImpl extends AbstractDao<Integer, Team> implements TeamDao {
    public Team findById(int id) { return getByKey(id); }

    public void saveTeam(Team team) {
        persist(team);
    }

    public void deleteTeamById(int id) {
        Query query = getSession().createSQLQuery("delete from TEAM where id = :id");
        query.setInteger("id", id);
        query.executeUpdate();
    }

    @SuppressWarnings("unchecked")
    public List<Team> findAllTeams() {
        Criteria criteria = createEntityCriteria();
        return (List<Team>) criteria.list();
    }

    public Team findTeamById(int id) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("id", id));
        return (Team) criteria.uniqueResult();
    }
}
