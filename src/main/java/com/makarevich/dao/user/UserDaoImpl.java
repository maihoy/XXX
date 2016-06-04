package com.makarevich.dao.user;

import com.makarevich.dao.AbstractDao;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.makarevich.dao.user.model.User;

import java.util.List;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Long, User> implements UserDao {

	public void save(User user) {
		persist(user);
	}
	
	public User findById(Long id) {
		return getByKey(id);
	}

	public User findByEmail(String email) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("email", email));
		return (User) crit.uniqueResult();
	}

	public void deleteUserById(Long id) {
		Query query = getSession().createSQLQuery("delete from USER where id = :id");
		query.setLong("id", id);
		query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public List<User> findAllUsers() {
		Criteria criteria = createEntityCriteria();
		return (List<User>) criteria.list();
	}
}
