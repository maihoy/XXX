package com.makarevich.service.front.user;

import com.makarevich.service.front.user.dto.UserDTO;

import java.util.List;

public interface UserService {

	UserDTO findById(Long id);
	
	UserDTO findByEmail(String email);

	void save(UserDTO user);

	void updateUser(UserDTO user);

	void deleteUserById(Long id);

	List<UserDTO> findAllUsers();
	
}