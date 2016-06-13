package com.makarevich.dao.action;

import com.makarevich.dao.action.model.Action;

public interface ActionDao {
    Action getByCode (String code);
    Action getById (Long id);

}
