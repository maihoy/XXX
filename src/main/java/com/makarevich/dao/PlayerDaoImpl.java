package com.makarevich.dao;

import com.makarevich.model.Player;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("playerDao")

public class PlayerDaoImpl extends AbstractDao<Integer, Player> implements PlayerDao {
    public Player findById(int id) { return getByKey(id); }

    public void savePlayer(Player player) {
        persist(player);
    }

    public void deletePlayerById(int id) {
        Query query = getSession().createSQLQuery("delete from PLAYER where id = :id");
        query.setInteger("id", id);
        query.executeUpdate();
    }

    @SuppressWarnings("unchecked")
    public List<Player> findAllPlayers() {
        Criteria criteria = createEntityCriteria();
        return (List<Player>) criteria.list();
    }

    public Player findPlayerById(int id) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("id", id));
        return (Player) criteria.uniqueResult();
    }

}
