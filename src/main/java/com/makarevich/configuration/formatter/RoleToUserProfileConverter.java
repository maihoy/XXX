package com.makarevich.configuration.formatter;

import com.makarevich.dao.user_role.model.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.makarevich.service.front.user_role.UserRoleService;

@Component
public class RoleToUserProfileConverter implements Converter<Object, UserRole>{

	@Autowired
	UserRoleService userProfileService;

	/*
	 * Gets UserRole by Id
	 * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
	 */
	public UserRole convert(Object element) {
		Long id = Long.parseLong((String)element);
		UserRole profile= userProfileService.findById(id);
		System.out.println("Profile : "+profile);
		return profile;
	}
	
	/*
	 * Gets UserRole by type
	 * @see org.springframework.core.convert.converter.Converter#convert(java.lang.Object)
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