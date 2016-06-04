package com.makarevich.dao.userrole;

import java.util.List;

import com.makarevich.dao.userrole.model.UserRole;

public interface UserRoleDao {

	List<UserRole> findAll();
	
	UserRole findByType(String type);
	
	UserRole findById(Long id);
}
