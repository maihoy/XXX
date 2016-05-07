package com.makarevich.service.front.user;

import com.makarevich.dao.user.model.User;

public interface UserService {

	void save(User user);
	
	User findById(Long id);
	
	User findByEmail(String email);
	
}