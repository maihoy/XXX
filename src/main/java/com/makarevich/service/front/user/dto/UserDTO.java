package com.makarevich.service.front.user.dto;

import com.makarevich.service.front.user_role.dto.UserRoleDTO;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

public class UserDTO {
    private Long id;

    @NotNull
    @Size(min= 1, max = 100)
    private String password;

    @NotNull
    @Size(min= 1, max = 45)
    private String firstName;

    @NotNull
    @Size(min= 1, max = 45)
    private String lastName;

    @NotNull
    @Email
    @Size(min= 1, max = 45)
    private String email;

//    @NotNull
//    @Size(min= 1, max = 45)
    private String state;

    private Set<UserRoleDTO> roles;

    public UserDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail (){return email;}

    public void setEmail(String email){ this.email= email;}

    public String getState (){return state;}

    public void setState(String state){ this.state= state;}

    public Set<UserRoleDTO> getRoles() {
        return roles;
    }

    public void setRoles(Set<UserRoleDTO> roles) {
        this.roles = roles;
    }
}
