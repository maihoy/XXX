package com.makarevich.dao.subaction;

import com.makarevich.dao.AbstractDao;
import com.makarevich.dao.subaction.model.SubAction;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("subActionDao")
public class SubActionDaoImpl  extends AbstractDao<Long, SubAction> implements SubActionDao {

    public SubAction getById(Long id) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("id", id));
        return (SubAction) criteria.uniqueResult();
    }

    public SubAction getByCode(String code) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("code", code));
        return (SubAction) criteria.uniqueResult();
    }

    public SubAction getByAction(Long action) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("action", action));
        return (SubAction) criteria.uniqueResult();
    }
}
