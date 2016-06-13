package com.makarevich.dao.actionresult;

import com.makarevich.dao.action.model.Action;
import com.makarevich.dao.actionresult.model.ActionResult;


public interface ActionResultDao {
    ActionResult getByCode (String code);
    ActionResult getById (Long id);
    ActionResult getByAction(Long action);
}
