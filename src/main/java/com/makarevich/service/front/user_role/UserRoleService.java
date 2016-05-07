package com.makarevich.service.front.user_role;

import java.util.List;

import com.makarevich.dao.user_role.model.UserRole;

public interface UserRoleService {

	List<UserRole> findAll();
	
	UserRole findByType(String type);
	
	UserRole findById(Long id);
}
