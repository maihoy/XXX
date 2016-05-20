package com.makarevich.service.front.user;

import com.makarevich.service.front.user.dto.UserDTO;

public interface UserService {

	void save(UserDTO user);
	
	UserDTO findById(Long id);
	
	UserDTO findByEmail(String email);
	
}