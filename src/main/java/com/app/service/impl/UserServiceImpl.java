package com.app.service.impl;

import java.util.List;

import org.apache.logging.slf4j.SLF4JLogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.bean.User;
import com.app.dao.UserDao;
import com.app.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	UserDao userDao;
	
	
	@Override
	public void createUser(User user) {
		logger.info("Createing the user :"+user);
    // userDao.createUser(user);
     
     userDao.save();
     
		
	}


	@Override
	public ResponseEntity<List<User>> getAllUsers() {
		
		logger.info("getting all the users");
		
		return userDao.getAllUsers();
	}

	

}
