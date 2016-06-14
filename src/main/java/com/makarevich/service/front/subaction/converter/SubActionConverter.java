package com.makarevich.service.front.subaction.converter;

import com.makarevich.converter.Converter;
import com.makarevich.dao.action.ActionDao;
import com.makarevich.dao.action.model.Action;
import com.makarevich.dao.actionresult.model.ActionResult;
import com.makarevich.dao.subaction.model.SubAction;
import com.makarevich.service.front.actionresult.dto.ActionResultDTO;
import com.makarevich.service.front.subaction.dto.SubActionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SubActionConverter implements Converter<SubAction, SubActionDTO>{

        @Autowired
        private ActionDao actionDao;

        public SubActionDTO convertToFront(SubAction subAction) {
            SubActionDTO dto = new SubActionDTO();
            dto.setId(subAction.getId());
            dto.setName(subAction.getName());
            dto.setCode(subAction.getCode());
            Action action = subAction.getAction();
            dto.setAction(action.getId());
            dto.setActionName(action.getName());

            return dto;
        }

        public SubAction convertToLocal(SubActionDTO subActionDTO, SubAction subAction) {
            subAction.setName(subActionDTO.getName());
            subAction.setCode(subActionDTO.getCode());
            subAction.setAction(actionDao.getById(subActionDTO.getAction()));
            return subAction;
        }
}




