package com.makarevich.service.front.user_role;

import java.util.ArrayList;
import java.util.List;

import com.makarevich.service.front.user_role.converter.UserRoleConverter;
import com.makarevich.service.front.user_role.dto.UserRoleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.makarevich.dao.user_role.UserRoleDao;
import com.makarevich.dao.user_role.model.UserRole;

@Service("userProfileService")
@Transactional
public class UserRoleServiceImpl implements UserRoleService {
	
	@Autowired
    private UserRoleDao dao;
	@Autowired
	private UserRoleConverter userRoleConverter;
	
	public List<UserRoleDTO> findAll() {
		List<UserRoleDTO> result = new ArrayList<UserRoleDTO>();
		List<UserRole> userRoles = dao.findAll();
		for (UserRole userRole : userRoles) {
			result.add(userRoleConverter.convertToFront(userRole));
		}
		return result;
	}

	public UserRoleDTO findByType(String type){
        UserRole byType = dao.findByType(type);
        return userRoleConverter.convertToFront(byType);
    }

	public UserRoleDTO findById(Long id) {
        UserRole byId = dao.findById(id);
        return userRoleConverter.convertToFront(byId);
    }
}
