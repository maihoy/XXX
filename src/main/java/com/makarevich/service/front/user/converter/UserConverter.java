package com.makarevich.service.front.user.converter;

import com.makarevich.converter.Converter;
import com.makarevich.dao.user.model.User;
import com.makarevich.dao.userrole.UserRoleDao;
import com.makarevich.dao.userrole.model.UserRole;
import com.makarevich.service.front.user.dto.UserDTO;
import com.makarevich.service.front.userrole.converter.UserRoleConverter;
import com.makarevich.service.front.userrole.dto.UserRoleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserConverter implements Converter<User, UserDTO>{

    @Autowired
    private UserRoleConverter userRoleConverter;
    @Autowired
    private UserRoleDao userRoleDao;

    public UserDTO convertToFront(User user){
        UserDTO userDTO = new UserDTO();

        userDTO.setId(user.getId());
        userDTO.setPassword(user.getPassword());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setEmail(user.getEmail());
        userDTO.setState(user.getState());

        for (UserRole userRole : user.getUserRoles()) {
            userDTO.getRoles().add(userRoleConverter.convertToFront(userRole));
        }
        return userDTO;
    }

    public User convertToLocal(UserDTO dto, User user){
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setPassword(dto.getPassword());
        user.setEmail(dto.getEmail());
        user.setState(dto.getState());

        user.getUserRoles().clear();
        for (UserRoleDTO userRoleDTO : dto.getRoles()) {
            UserRole userRole = userRoleDao.findById(userRoleDTO.getId());
            user.getUserRoles().add(userRole);
        }

        return user;
    }

}