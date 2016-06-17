package com.makarevich.dao.match;


import com.makarevich.dao.AbstractDao;
import com.makarevich.dao.match.model.Match;
import com.makarevich.dao.match.model.Score;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("matchDao")

public class MatchDaoImpl extends AbstractDao<Long, Score> implements MatchDao {

   /* public void saveMatch(Match match) {        persist(match);    }

    public void deleteMatchById(Long id) {
        Query query = getSession().createSQLQuery("delete from MATCH where id = :id");
        query.setLong("id", id);
        query.executeUpdate();
    }

    @SuppressWarnings("unchecked")
    public List<Match> findAllMatches() {
        Criteria criteria = createEntityCriteria();
        return (List<Match>) criteria.list();
    }

    public Match findMatchById(Long id) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("id", id));
        return (Match) criteria.uniqueResult();
    }

**/
    public void saveScore(Score score) {
        persist(score);
    }

    public void deleteScoreById(Long id) {
        Query query = getSession().createSQLQuery("delete from SCORE where id = :id");
        query.setLong("id", id);
        query.executeUpdate();
    }

    @SuppressWarnings("unchecked")
    public List<Score> findAllScores() {
        Criteria criteria = createEntityCriteria();
        return (List<Score>) criteria.list();
    }

    public Score findScoreById(Long id) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("id", id));
        return (Score) criteria.uniqueResult();
    }
}
