package com.makarevich.dao.team;

import java.util.List;

import com.makarevich.dao.AbstractDao;
import com.makarevich.dao.team.model.Team;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("teamDao")

public class TeamDaoImpl extends AbstractDao<Long, Team> implements TeamDao {
   // public Team findById(Long id) { return getByKey(id); }

    public void saveTeam(Team team) {
        persist(team);
    }

    public void deleteTeamById(Long id) {
        Query query = getSession().createSQLQuery("delete from TEAM where id = :id");
        query.setLong("id", id);
        query.executeUpdate();
    }

    @SuppressWarnings("unchecked")
    public List<Team> findAllTeams() {
        Criteria criteria = createEntityCriteria();
        return (List<Team>) criteria.list();
    }

    public Team findTeamById(Long id) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("id", id));
        return (Team) criteria.uniqueResult();
    }
}
