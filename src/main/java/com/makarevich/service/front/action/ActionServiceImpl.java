package com.makarevich.service.front.action;

import com.makarevich.dao.action.ActionDao;
import com.makarevich.dao.action.model.Action;
import com.makarevich.service.front.action.converter.ActionConverter;
import com.makarevich.service.front.action.dto.ActionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("actionService")
@Transactional
public class ActionServiceImpl implements ActionService{

    @Autowired
    private ActionDao dao;
    @Autowired
    private ActionConverter actionConverter;

    public ActionDTO getById(Long id) {
        Action action = dao.getById(id);
        return actionConverter.convertToFront(action);
    }

    public ActionDTO getByCode(String code) {
        Action action = dao.getByCode(code);
        return actionConverter.convertToFront(action);
    }

}
