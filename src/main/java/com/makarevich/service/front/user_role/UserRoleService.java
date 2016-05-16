package com.makarevich.service.front.user_role;

import java.util.List;

import com.makarevich.service.front.user_role.dto.UserRoleDTO;

public interface UserRoleService {

	List<UserRoleDTO> findAll();

	UserRoleDTO findByType(String type);

	UserRoleDTO findById(Long id);
}
