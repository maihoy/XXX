package com.makarevich.service.front.user.converter;

import com.makarevich.converter.Converter;
import com.makarevich.dao.user.model.User;
import com.makarevich.service.front.user.dto.UserDTO;
import org.springframework.stereotype.Component;

@Component
public class UserConverter implements Converter<User, UserDTO>{

    public UserDTO convertToFront(User user){
        UserDTO userDTO = new UserDTO();

        userDTO.setId(user.getId());
        userDTO.setPassword(user.getPassword());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        userDTO.setEmail(user.getEmail());
        userDTO.setState(user.getState());

        return userDTO;
    }

    public User convertToLocal(UserDTO dto, User user){
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setPassword(dto.getPassword());
        user.setEmail(dto.getEmail());
        user.setState(dto.getState());

        return user;
    }

}