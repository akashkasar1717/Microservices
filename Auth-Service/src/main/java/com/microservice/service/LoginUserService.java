package com.microservice.service;

//import org.springframework.security.core.userdetails.UserDetails;

import com.microservice.entities.LoginUser;

public interface LoginUserService {

	void saveUser(LoginUser loginUser);

//	UserDetails loadUserByUserName(String username);

}
