package com.makarevich.service.front.user;

import com.makarevich.dao.userrole.model.State;
import com.makarevich.service.front.user.converter.UserConverter;
import com.makarevich.service.front.user.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.makarevich.dao.user.UserDao;
import com.makarevich.dao.user.model.User;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao dao;
	@Autowired
	private UserConverter userConverter;
	@Autowired
	private PasswordEncoder passwordEncoder;

	
	public void save(UserDTO user){
		user.setState(State.ACTIVE.getState());
		if(user.getId() != null){
			User entity = dao.findById(user.getId());
			dao.save(userConverter.convertToLocal(user, entity));
		} else {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			User userEntity = userConverter.convertToLocal(user, new User());
			dao.save(userEntity);
		}
	}
	
	public UserDTO findById(Long id) {
		User user = dao.findById(id);
		return userConverter.convertToFront(user);
	}

	public UserDTO findByEmail(String email) {
		User user = dao.findByEmail(email);
		return userConverter.convertToFront(user);
	}

	public void updateUser(UserDTO user) {
		User entity = dao.findById(user.getId());
		if(entity!=null){
			userConverter.convertToLocal(user, entity);
		}
	}

	public void deleteUserById(Long id) {
		dao.deleteUserById(id);
	}

	public List<UserDTO> findAllUsers() {
		List<User> users = dao.findAllUsers();
		List<UserDTO> result = new ArrayList<UserDTO>(users.size());
		for (User user : users) {
			result.add(userConverter.convertToFront(user));
		}

		return result;
	}


}
