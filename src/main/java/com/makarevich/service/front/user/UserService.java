package com.makarevich.service.front.user;

import com.makarevich.dao.user.model.User;
import com.makarevich.service.front.user.dto.UserDTO;

public interface UserService {

	void save(UserDTO user);
	
	User findById(Long id);
	
	User findByEmail(String email);
	
}