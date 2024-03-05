package com.app.dao;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.app.bean.BankAccountCreatedResponse;
import com.app.entity.BankAccount;

public interface BankAccountDao {
	
	public BankAccountCreatedResponse save(BankAccount bankAccount);

	public ResponseEntity<List<BankAccount>> getAllBankAccounts();

	public BankAccount getAccoutDetailsById(Long bankAccountNumber);
	
	public BankAccount saveOrUpdate(BankAccount bankAccount);
	
	public void deleteByAccountId(Long accountNumber) throws Exception;

}
