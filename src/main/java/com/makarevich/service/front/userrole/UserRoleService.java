package com.makarevich.service.front.userrole;

import java.util.List;

import com.makarevich.service.front.userrole.dto.UserRoleDTO;

public interface UserRoleService {

	List<UserRoleDTO> findAll();

	UserRoleDTO findByType(String type);

	UserRoleDTO findById(Long id);
}
