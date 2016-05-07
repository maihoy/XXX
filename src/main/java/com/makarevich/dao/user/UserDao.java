package com.makarevich.dao.user;

import com.makarevich.dao.user.model.User;

public interface UserDao {

	void save(User user);
	
	User findById(Long id);
	
	User findByEmail(String email);
	
}

