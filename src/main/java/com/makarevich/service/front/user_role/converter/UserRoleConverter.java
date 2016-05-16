package com.makarevich.service.front.user_role.converter;

import com.makarevich.converter.Converter;
import com.makarevich.dao.userrole.model.UserRole;
import com.makarevich.service.front.user_role.dto.UserRoleDTO;
import org.springframework.stereotype.Component;

@Component
public class UserRoleConverter implements Converter<UserRole, UserRoleDTO>{

    public UserRoleDTO convertToFront(UserRole userProfile){
        UserRoleDTO userProfileDTO = new UserRoleDTO();

        userProfileDTO.setId(userProfile.getId());
        userProfileDTO.setType(userProfile.getType());

        return userProfileDTO;
    }

    public UserRole convertToLocal(UserRoleDTO dto, UserRole userRole){
        userRole.setType(dto.getType());

        return userRole;
    }

}
