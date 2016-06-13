package com.makarevich.service.front.action;

import com.makarevich.service.front.action.dto.ActionDTO;

public interface ActionService {
    ActionDTO getById(Long id);
    ActionDTO getByCode(String code);
}
