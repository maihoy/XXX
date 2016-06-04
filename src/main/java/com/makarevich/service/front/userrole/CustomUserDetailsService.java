package com.makarevich.service.front.userrole;

import java.util.ArrayList;
import java.util.List;

import com.makarevich.service.front.user.UserService;
import com.makarevich.service.front.user.dto.UserDTO;
import com.makarevich.service.front.userrole.dto.UserRoleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.makarevich.dao.user.model.User;
import com.makarevich.dao.userrole.model.UserRole;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UserService userService;
	
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String email)
			throws UsernameNotFoundException {
		UserDTO user = userService.findByEmail(email);
		System.out.println("User : "+user);
		if(user==null){
			System.out.println("User not found");
			throw new UsernameNotFoundException("Username not found"); 
		}
			return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
				 user.getState().equals("Active"), true, true, true, getGrantedAuthorities(user));
	}

	
	private List<GrantedAuthority> getGrantedAuthorities(UserDTO user){
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		for(UserRoleDTO userRole : user.getRoles()){
			System.out.println("UserRole : "+userRole);
			authorities.add(new SimpleGrantedAuthority("ROLE_"+userRole.getType()));
		}
		System.out.print("authorities :"+authorities);
		return authorities;
	}
	
}
