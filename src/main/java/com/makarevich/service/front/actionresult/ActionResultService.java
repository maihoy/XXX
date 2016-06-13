package com.makarevich.service.front.actionresult;

import com.makarevich.service.front.actionresult.dto.ActionResultDTO;

public interface ActionResultService {
    ActionResultDTO getById(Long id);
    ActionResultDTO getByCode(String code);
    ActionResultDTO getByAction(Long action);
}
