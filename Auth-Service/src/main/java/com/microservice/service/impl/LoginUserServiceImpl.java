package com.microservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.microservice.entities.LoginUser;
import com.microservice.repository.LoginUserRepository;
import com.microservice.service.LoginUserService;

@Service
public class LoginUserServiceImpl implements LoginUserService {
	
	@Autowired
	LoginUserRepository loginUserRepo;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public void saveUser(LoginUser loginUser) {
		try {
			loginUser.setPassword(passwordEncoder.encode(loginUser.getPassword()));
			loginUserRepo.save(loginUser);			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
//
//	@Override
//	public UserDetails loadUserByUserName(String username) {
//		return loadUserByUserName(username);
//	}

}
