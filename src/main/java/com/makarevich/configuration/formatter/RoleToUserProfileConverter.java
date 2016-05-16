package com.makarevich.configuration.formatter;

import com.makarevich.dao.userrole.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.makarevich.service.front.user_role.UserRoleService;

@Component
public class RoleToUserProfileConverter implements Converter<Object, UserRole>{

	@Autowired
	UserRoleService userRoleService;


	public UserRole convert(Object element) {
		Long id = Long.parseLong((String)element);
		UserRole role= userRoleService.findById(id);
		System.out.println("Profile : "+role);
		return role;
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