package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.bean.User;
import com.app.service.UserService;

@RestController
public class UserController {
	
	
	@Autowired
	UserService userService;
	
	
	
	
	@PostMapping("/createUser")
	public ResponseEntity createUser(@RequestBody User user) {
		
		userService.createUser(user);
		return new ResponseEntity("Success",HttpStatus.OK);
	}
	
	
	@GetMapping("/getAllUsers")
	public ResponseEntity<List<User>> getAllUsers(){
		
		return userService.getAllUsers();
		
	}
	

}
