package com.makarevich.configuration.formatter;

import com.makarevich.service.front.userrole.dto.UserRoleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.makarevich.service.front.userrole.UserRoleService;

@Component
public class RoleToUserProfileConverter implements Converter<UserRoleDTO, UserRoleDTO>{

	//@Autowired
	//private UserRoleService userRoleService;


	public UserRoleDTO convert(UserRoleDTO element) {return element;	}


}