package com.makarevich.dao.player;

import com.makarevich.dao.player.model.Player;

import java.util.List;

public interface PlayerDao {

    void savePlayer(Player player);
    void deletePlayerById(Long id);
    List<Player> findAllPlayers();
    Player findById(Long id);
}
