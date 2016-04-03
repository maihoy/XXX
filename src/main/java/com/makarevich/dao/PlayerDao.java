package com.makarevich.dao;

import com.makarevich.model.Player;

import java.util.List;

public interface PlayerDao {

    void savePlayer(Player player);
    void deletePlayerById(int id);
    List<Player> findAllPlayers();
    Player findById(int id);
}
