package com.makarevich.dao.subaction;

import com.makarevich.dao.subaction.model.SubAction;

public interface SubActionDao {
    SubAction getByCode (String code);
    SubAction getById (Long id);
    SubAction getByAction(Long action);
}
