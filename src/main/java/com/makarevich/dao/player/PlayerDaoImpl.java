package com.makarevich.dao.player;

import com.makarevich.dao.AbstractDao;
import com.makarevich.dao.player.model.Player;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("playerDao")

public class PlayerDaoImpl extends AbstractDao<Long, Player> implements PlayerDao {

    public void savePlayer(Player player) {

        persist(player);
    }

    public void deletePlayerById(Long id) {
        Query query = getSession().createSQLQuery("delete from PLAYER where id = :id");
        query.setLong("id", id);
        query.executeUpdate();
    }

    @SuppressWarnings("unchecked")
    public List<Player> findAllPlayers() {
        Criteria criteria = createEntityCriteria();
        return (List<Player>) criteria.list();
    }

    public Player findPlayerById(Long id) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("id", id));
        return (Player) criteria.uniqueResult();
    }

}
