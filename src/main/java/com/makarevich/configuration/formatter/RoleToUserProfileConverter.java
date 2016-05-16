package com.makarevich.configuration.formatter;

import com.makarevich.dao.user_role.model.UserRole;
import com.makarevich.service.front.user_role.dto.UserRoleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.makarevich.service.front.user_role.UserRoleService;

@Component
public class RoleToUserProfileConverter implements Converter<UserRoleDTO, UserRoleDTO>{

	@Autowired
	UserRoleService userRoleService;


	public UserRoleDTO convert(UserRoleDTO element) {
//		Long id = Long.parseLong((String)element);
//		UserRoleDTO role= userRoleService.findById(id);
//		System.out.println("Profile : "+role);
		return element;
	}
	
	/*
	 * Gets UserRole by type
	 */
	/*
	public UserRole convert(Object element) {
		String type = (String)element;
		UserRole profile= userProfileService.findByType(type);
		System.out.println("Profile ... : "+profile);
		return profile;
	}
	*/

}