package com.makarevich.service.front.match.converter;

import com.makarevich.converter.Converter;
import com.makarevich.dao.action.ActionDao;
import com.makarevich.dao.action.model.Action;
import com.makarevich.dao.actionresult.ActionResultDao;
import com.makarevich.dao.actionresult.model.ActionResult;
import com.makarevich.dao.match.model.RallyItem;
import com.makarevich.dao.player.PlayerDao;
import com.makarevich.dao.player.model.Player;
import com.makarevich.dao.subaction.SubActionDao;
import com.makarevich.dao.subaction.model.SubAction;
import com.makarevich.service.front.match.dto.RallyItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RallyItemConverter implements Converter<RallyItem, RallyItemDTO> {

    @Autowired
    private PlayerDao playerDao;
    @Autowired
    private ActionDao actionDao;
    @Autowired
    private SubActionDao subActionDao;
    @Autowired
    private ActionResultDao actionResultDao;

        public RallyItemDTO convertToFront(RallyItem rallyItem) {
            RallyItemDTO dto = new RallyItemDTO();
            dto.setId(rallyItem.getId());

            Player player = rallyItem.getPlayer();
            dto.setPlayer(player.getId());
            dto.setPlayerName(player.getName());

            Action action = rallyItem.getAction();
            dto.setAction(action.getId());
            dto.setActionName(action.getName());

            SubAction subAction = rallyItem.getSubAction();
            dto.setSubAction(subAction.getId());
            dto.setSubActionName(subAction.getName());

            ActionResult actionResult = rallyItem.getActionResult();
            dto.setActionResult(actionResult.getId());
            dto.setActionResultName(actionResult.getName());

            return dto;
        }

        public RallyItem convertToLocal(RallyItemDTO rallyItemDTO, RallyItem rallyItem) {
            rallyItem.setPlayer(playerDao.findPlayerById(rallyItemDTO.getPlayer()));
            rallyItem.setAction(actionDao.getById(rallyItemDTO.getAction()));
            rallyItem.setSubAction(subActionDao.getById(rallyItemDTO.getSubAction()));
            rallyItem.setActionResult(actionResultDao.getById(rallyItemDTO.getActionResult()));

            return rallyItem;
        }
    }

