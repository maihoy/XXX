package com.makarevich.dao.user_role;

import java.util.List;

import com.makarevich.dao.user_role.model.UserRole;

public interface UserRoleDao {

	List<UserRole> findAll();
	
	UserRole findByType(String type);
	
	UserRole findById(Long id);
}
