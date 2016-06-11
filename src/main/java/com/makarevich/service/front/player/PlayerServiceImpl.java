package com.makarevich.service.front.player;

import com.makarevich.dao.player.PlayerDao;
import com.makarevich.dao.player.model.Player;
import com.makarevich.service.front.player.converter.PlayerConverter;
import com.makarevich.service.front.player.dto.PlayerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("playerService")
@Transactional
public class PlayerServiceImpl implements PlayerService{

    @Autowired
    private PlayerDao dao;
    @Autowired
    private PlayerConverter playerConverter;

    public PlayerDTO findPlayerById(Long id) {
        Player player = dao.findPlayerById(id);
        return playerConverter.convertToFront(player);
    }

    public void savePlayer(PlayerDTO player) {
        if(player.getId() != null){
            Player entity = dao.findPlayerById(player.getId());
            dao.savePlayer(playerConverter.convertToLocal(player, entity));
        } else {
            dao.savePlayer(playerConverter.convertToLocal(player, new Player()));
        }
    }


    public void updatePlayer(PlayerDTO player) {
        Player entity = dao.findPlayerById(player.getId());
        if(entity!=null){
            playerConverter.convertToLocal(player, entity);
        }
    }

    public void deletePlayerById(Long id) {
        dao.deletePlayerById(id);
    }

    public List<PlayerDTO> findAllPlayers() {
        List<Player> players = dao.findAllPlayers();
        List<PlayerDTO> result = new ArrayList<PlayerDTO>(players.size());
        for (Player player : players) {
            result.add(playerConverter.convertToFront(player));
        }

        return result;
    }


}
