package com.makarevich.service;

import com.makarevich.dao.PlayerDao;
import com.makarevich.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("playerService")
@Transactional
public class PlayerServiceImpl implements PlayerService{

    @Autowired
    private PlayerDao dao;

    public Player findById(int id) {
        return dao.findById(id);
    }

    public void savePlayer(Player player) {
        dao.savePlayer(player);
    }


    public void updatePlayer(Player player) {
        Player entity = dao.findById(player.getId());
        if(entity!=null){
            entity.setName(player.getName());
            entity.setSurname(player.getSurname());
            entity.setTeam(player.getTeam());
        }
    }

    public void deletePlayerById(int id) {
        dao.deletePlayerById(id);
    }

    public List<Player> findAllPlayers() {
        return dao.findAllPlayers();
    }


}
