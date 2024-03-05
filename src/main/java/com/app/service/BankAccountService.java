package com.app.service;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.http.ResponseEntity;

import com.app.bean.BankAccountCreatedResponse;
import com.app.bean.BankAccountUpdateRequestVO;
import com.app.bean.BankAccountVO;
import com.app.bean.CreateAccountAPIResponse;
import com.app.entity.BankAccount;
import com.app.exception.BankAccountNotFoundExcpetion;
import com.app.exception.InputInvalidExcpetion;

public interface BankAccountService {


	public BankAccountCreatedResponse createBankAccount(BankAccountVO bankAccountVO);

	public ResponseEntity<List<BankAccount>> getAllBankAccounts();

	public void getDatafromRestApi() throws NoSuchAlgorithmException;

	public CreateAccountAPIResponse createAccountUsingRestApi();

	public ResponseEntity<String> updateBankAccountById(BankAccountUpdateRequestVO request) throws BankAccountNotFoundExcpetion, InputInvalidExcpetion;

	public ResponseEntity<String> deleteByAccountId(Long id);

}
