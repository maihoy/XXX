package com.makarevich.service.front.actionresult.converter;

import com.makarevich.converter.Converter;
import com.makarevich.dao.action.ActionDao;
import com.makarevich.dao.action.model.Action;
import com.makarevich.dao.actionresult.model.ActionResult;
import com.makarevich.dao.player.model.Player;
import com.makarevich.service.front.actionresult.dto.ActionResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ActionResultConverter implements Converter<ActionResult, ActionResultDTO> {

        @Autowired
        private ActionDao actionDao;

        public ActionResultDTO convertToFront(ActionResult actionResult) {
            ActionResultDTO dto = new ActionResultDTO();
            dto.setId(actionResult.getId());
            dto.setName(actionResult.getName());
            dto.setCode(actionResult.getCode());
            dto.setStatus(actionResult.getStatus());
            Action action = actionResult.getAction();
            dto.setAction(action.getId());
            dto.setActionName(action.getName());

            return dto;
        }

        public ActionResult convertToLocal(ActionResultDTO actionResultDTO, ActionResult actionResult) {
            actionResult.setName(actionResultDTO.getName());
            actionResult.setCode(actionResultDTO.getCode());
            actionResult.setStatus(actionResultDTO.getStatus());
            actionResult.setAction(actionDao.getById(actionResultDTO.getAction()));
            return actionResult;
        }
    }


