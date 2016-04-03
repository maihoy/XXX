package com.makarevich.service;

import com.makarevich.model.Player;

import java.util.List;

/**
 * Created by j on 3.4.16.
 */
public interface PlayerService {
    Player findById(int id);

    void savePlayer(Player player);

    void updatePlayer(Player player);

    void deletePlayerById(int id);

    List<Player> findAllPlayers();
}
