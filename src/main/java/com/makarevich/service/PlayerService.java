package com.makarevich.service;

import com.makarevich.model.Player;

import java.util.List;

public interface PlayerService {
    Player findById(int id);

    void savePlayer(Player player);

    void updatePlayer(Player player);

    void deletePlayerById(int id);

    List<Player> findAllPlayers();
}
