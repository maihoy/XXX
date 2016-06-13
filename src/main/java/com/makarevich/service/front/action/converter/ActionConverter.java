package com.makarevich.service.front.action.converter;

import com.makarevich.converter.Converter;
import com.makarevich.dao.action.model.Action;
import com.makarevich.service.front.action.dto.ActionDTO;
import org.springframework.stereotype.Component;

@Component
public class ActionConverter implements Converter<Action,ActionDTO>{

    public ActionDTO convertToFront(Action player) {
        ActionDTO dto = new ActionDTO();
        dto.setId(player.getId());
        dto.setName(player.getName());
        dto.setCode(player.getCode());

        return dto;
    }

    public Action convertToLocal(ActionDTO actionDTO, Action action) {
        action.setName(actionDTO.getName());
        action.setCode(actionDTO.getCode());

        return action;
    }
}
