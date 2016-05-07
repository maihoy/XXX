package com.makarevich.dao.user_role;

import java.util.List;

import com.makarevich.dao.AbstractDao;
import com.makarevich.dao.user_role.model.UserRole;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("userProfileDao")
public class UserRoleDaoImpl extends AbstractDao<Long, UserRole> implements UserRoleDao {

	@SuppressWarnings("unchecked")
	public List<UserRole> findAll(){
		Criteria crit = createEntityCriteria();
		crit.addOrder(Order.asc("type"));
		return (List<UserRole>)crit.list();
	}
	
	public UserRole findById(Long id) {
		return getByKey(id);
	}
	
	public UserRole findByType(String type) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("type", type));
		return (UserRole) crit.uniqueResult();
	}
}
