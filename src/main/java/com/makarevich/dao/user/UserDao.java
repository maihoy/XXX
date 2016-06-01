package com.makarevich.dao.user;

import com.makarevich.dao.user.model.User;

import java.util.List;

public interface UserDao {

	void save(User user);
	User findById(Long id);
	User findByEmail(String email);
	void deleteUserById(Long id);
	List<User> findAllUsers();
	
}

