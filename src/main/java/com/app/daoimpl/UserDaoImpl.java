package com.app.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.app.bean.User;
import com.app.dao.UserDao;
import com.app.entity.BankAccount;
import com.app.repository.BankAccountRepository;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
	BankAccountRepository bankAccountRepository;
	
	public static List<User> users=new ArrayList();

	@Override
	public void createUser(User user) {
		
		users.add(user);
		
	}

	@Override
	public ResponseEntity<List<User>> getAllUsers() {
		
		return new ResponseEntity<List<User>>(users,HttpStatus.OK);
	}

	@Override
	public void save() {
		
		BankAccount bankAccount=new BankAccount();
		
		//bankAccount.setBankAccountNumber((long) 100);
		bankAccount.setAccountHolderName("chandu");
		bankAccount.setMobileNumber("8499998880");
		bankAccount.setBalance((long) 1);
		bankAccountRepository.save(bankAccount);
		
	}
	

}
