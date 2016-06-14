package com.makarevich.service.front.subaction;


import com.makarevich.dao.subaction.SubActionDao;
import com.makarevich.dao.subaction.model.SubAction;
import com.makarevich.service.front.subaction.converter.SubActionConverter;
import com.makarevich.service.front.subaction.dto.SubActionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("subActionService")
@Transactional
public class SubActionServiceImpl implements SubActionService{

        @Autowired
        private SubActionDao dao;
        @Autowired
        private SubActionConverter subActionConverter;

        public SubActionDTO getById(Long id) {
            SubAction subAction = dao.getById(id);
            return subActionConverter.convertToFront(subAction);
        }

        public SubActionDTO getByCode(String code) {
            SubAction subAction = dao.getByCode(code);
            return subActionConverter.convertToFront(subAction);
        }

        public SubActionDTO getByAction(Long action) {
            SubAction subAction = dao.getByAction(action);
            return subActionConverter.convertToFront(subAction);
        }

}
