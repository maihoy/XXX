package com.makarevich.service.front.user_role;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.makarevich.dao.userrole.UserRoleDao;
import com.makarevich.dao.userrole.model.UserRole;

@Service("userProfileService")
@Transactional
public class UserRoleServiceImpl implements UserRoleService {
	
	@Autowired
	UserRoleDao dao;
	
	public List<UserRole> findAll() {
		return dao.findAll();
	}

	public UserRole findByType(String type){
		return dao.findByType(type);
	}

	public UserRole findById(Long id) {
		return dao.findById(id);
	}
}
