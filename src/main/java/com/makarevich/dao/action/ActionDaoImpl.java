package com.makarevich.dao.action;

import com.makarevich.dao.AbstractDao;
import com.makarevich.dao.action.model.Action;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("actionDao")

public class ActionDaoImpl extends AbstractDao<Long, Action> implements ActionDao {

    public Action getById(Long id) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("id", id));
        return (Action) criteria.uniqueResult();
    }

    public Action getByCode(String code) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("code", code));
        return (Action) criteria.uniqueResult();
    }

}
