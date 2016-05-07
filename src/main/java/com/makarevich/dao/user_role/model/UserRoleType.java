package com.makarevich.dao.user_role.model;

public enum UserRoleType {
	USER("USER"),
	ADMIN("ADMIN");
	
	String userProfileType;
	
	private UserRoleType(String userProfileType){
		this.userProfileType = userProfileType;
	}
	
	public String getUserProfileType(){
		return userProfileType;
	}
	
}
