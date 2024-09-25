package com.microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.entities.LoginUser;
import com.microservice.service.LoginUserService;
import com.microservice.utils.JwtUtils;

@RestController
@RequestMapping("/user")
public class LoginUserController {

	@Autowired
	LoginUserService loginUserService;
	@Autowired
	JwtUtils jwtUtils; 
	
	@PostMapping("/postUser")
	public ResponseEntity<String> saveUser(@RequestBody LoginUser loginUser){
		loginUserService.saveUser(loginUser);
		return ResponseEntity.ok("Saved Successfully");
	}
	
//	@GetMapping("/get")
//	public String getUser() {
//		String token = jwtUtils.generateToken("AKASHKASAR");
//		System.out.println(token);
//		return "Working";
//	}
}
