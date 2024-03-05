package com.app.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.app.bean.User;

public interface UserService {
	
	public void createUser(User user);

	public ResponseEntity<List<User>> getAllUsers();

}
