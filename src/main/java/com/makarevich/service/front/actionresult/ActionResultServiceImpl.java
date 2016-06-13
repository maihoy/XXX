package com.makarevich.service.front.actionresult;

import com.makarevich.dao.actionresult.ActionResultDao;
import com.makarevich.dao.actionresult.model.ActionResult;
import com.makarevich.service.front.actionresult.converter.ActionResultConverter;
import com.makarevich.service.front.actionresult.dto.ActionResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("actionResultService")
@Transactional
public class ActionResultServiceImpl implements ActionResultService {
    
        @Autowired
        private ActionResultDao dao;
        @Autowired
        private ActionResultConverter actionResultConverter;

        public ActionResultDTO getById(Long id) {
            ActionResult actionResult = dao.getById(id);
            return actionResultConverter.convertToFront(actionResult);
        }

    public ActionResultDTO getByCode(String code) {
        ActionResult actionResult = dao.getByCode(code);
        return actionResultConverter.convertToFront(actionResult);
    }

    public ActionResultDTO getByAction(Long action) {
        ActionResult actionResult = dao.getByAction(action);
        return actionResultConverter.convertToFront(actionResult);
    }

}
