package com.makarevich.service.front.subaction;

import com.makarevich.service.front.subaction.dto.SubActionDTO;

public interface SubActionService {
    SubActionDTO getById(Long id);
    SubActionDTO getByCode(String code);
    SubActionDTO getByAction(Long action);
}
