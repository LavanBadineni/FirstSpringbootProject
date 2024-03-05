package com.app.dao;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.app.bean.User;

public interface UserDao {
	
	
	public void createUser(User user);

	public ResponseEntity<List<User>> getAllUsers();
	
	public void  save();

}
