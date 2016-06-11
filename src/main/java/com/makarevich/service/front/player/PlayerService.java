package com.makarevich.service.front.player;

import com.makarevich.dao.player.model.Player;
import com.makarevich.service.front.player.dto.PlayerDTO;

import java.util.List;

public interface PlayerService {
    PlayerDTO findPlayerById(Long id);

    void savePlayer(PlayerDTO player);

    void updatePlayer(PlayerDTO player);

    void deletePlayerById(Long id);

    List<PlayerDTO> findAllPlayers();
}
