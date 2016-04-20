package com.makarevich.service.front.player.converter;

import com.makarevich.converter.Converter;
import com.makarevich.dao.player.model.Player;
import com.makarevich.dao.team.TeamDao;
import com.makarevich.dao.team.model.Team;
import com.makarevich.service.front.player.dto.PlayerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * User: svetlana.voyteh
 * Date: 14.04.2016
 */
@Component
public class PlayerConverter implements Converter<Player, PlayerDTO> {

    @Autowired
    private TeamDao teamDao;

    public PlayerDTO convertToFront(Player player) {
        PlayerDTO dto = new PlayerDTO();
        dto.setId(player.getId());
        dto.setName(player.getName());
        dto.setSurname(player.getSurname());

        Team team = player.getTeam();
        dto.setTeam(team.getId());
        dto.setTeamName(team.getName());

        return dto;
    }

    public Player convertToLocal(PlayerDTO playerDTO, Player player) {
        player.setName(playerDTO.getName());
        player.setSurname(playerDTO.getSurname());
        player.setTeam(teamDao.findById(playerDTO.getTeam()));
        return player;
    }
}
