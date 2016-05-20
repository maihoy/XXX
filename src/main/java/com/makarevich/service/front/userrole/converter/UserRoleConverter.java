package com.makarevich.service.front.userrole.converter;

import com.makarevich.converter.Converter;
import com.makarevich.dao.userrole.model.UserRole;
import com.makarevich.service.front.userrole.dto.UserRoleDTO;
import org.springframework.stereotype.Component;

@Component
public class UserRoleConverter implements Converter<UserRole, UserRoleDTO>{

    public UserRoleDTO convertToFront(UserRole userRole){
        UserRoleDTO userRoleDTO = new UserRoleDTO();

        userRoleDTO.setId(userRole.getId());
        userRoleDTO.setType(userRole.getType());

        return userRoleDTO;
    }

    public UserRole convertToLocal(UserRoleDTO dto, UserRole userRole){
        userRole.setType(dto.getType());

        return userRole;
    }

}
