package com.makarevich.dao.actionresult;

import com.makarevich.dao.AbstractDao;
import com.makarevich.dao.actionresult.model.ActionResult;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("actionResultDao")
public class ActionResultDaoImpl extends AbstractDao<Long, ActionResult> implements ActionResultDao {

    public ActionResult getById(Long id) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("id", id));
        return (ActionResult) criteria.uniqueResult();
    }

    public ActionResult getByCode(String code) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("code", code));
        return (ActionResult) criteria.uniqueResult();
    }

    public ActionResult getByAction(Long action) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("action", action));
        return (ActionResult) criteria.uniqueResult();
    }
}
