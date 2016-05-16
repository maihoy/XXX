package com.makarevich.dao.user.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.makarevich.dao.user_role.model.State;
import com.makarevich.dao.user_role.model.UserRole;

@Entity
@Table(name="USER")
public class User {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;


	@Column(name="password", nullable=false)
	private String password;
		

	@Column(name="first_name", nullable=false)
	private String firstName;


	@Column(name="last_name", nullable=false)
	private String lastName;


	@Column(name="email", nullable=false)
	private String email;


	@Column(name="state", nullable=false)
	private String state= State.ACTIVE.getState();

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "USER_PROFILE",
             joinColumns = { @JoinColumn(name = "user_id") },
             inverseJoinColumns = { @JoinColumn(name = "user_role_id") })
	private Set<UserRole> userRoles = new HashSet<UserRole>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Set<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<UserRole> userRoles) {
		this.userRoles = userRoles;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof User))
			return false;
		User other = (User) obj;
		if (id != other.id)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password
				+ ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", state=" + state + ", userProfiles=" + userRoles +"]";
	}

	
}
