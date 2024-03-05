package com.app.controller;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.bean.BankAccountCreatedResponse;
import com.app.bean.BankAccountUpdateRequestVO;
import com.app.bean.BankAccountVO;
import com.app.bean.CreateAccountAPIResponse;
import com.app.entity.BankAccount;
import com.app.exception.BankAccountNotFoundExcpetion;
import com.app.exception.InputInvalidExcpetion;
import com.app.service.BankAccountService;

@RestController
@RequestMapping("/bank")
public class BankAccountController {
	
	@Autowired
	BankAccountService bankService;
	
	@PostMapping("/createBankAccount")
	public ResponseEntity<BankAccountCreatedResponse> createNewBankAccount(@RequestBody @Valid BankAccountVO bankAccountVO) {
		
		BankAccountCreatedResponse response=bankService.createBankAccount(bankAccountVO);
		
		return new ResponseEntity(response,HttpStatus.OK);
		
	}

	
	@GetMapping("/getAllBankAccounts")
	public ResponseEntity<List<BankAccount>> getAllBankAccounts() {
		
		return bankService.getAllBankAccounts();
		
	}
	
	
	@GetMapping("/testRestapi")
	public ResponseEntity testSampleRestApi() {
		 try {
			bankService.getDatafromRestApi();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	@PostMapping("create-account-using-rest")
	public ResponseEntity<CreateAccountAPIResponse> createAccountUsingRestapi(){
		
		CreateAccountAPIResponse response=bankService.createAccountUsingRestApi();
		
		return new ResponseEntity<CreateAccountAPIResponse>(response,HttpStatus.OK);
	}

	
	@PutMapping("/update-bank-account")
	public ResponseEntity<String> updateBankAccount(@RequestBody @Valid BankAccountUpdateRequestVO request ) throws BankAccountNotFoundExcpetion, InputInvalidExcpetion{
		
		
		return bankService.updateBankAccountById(request);
		
	}
	
	
	@DeleteMapping("/deleteById/{id}")
     public ResponseEntity<String> deleteBankAccount(@PathVariable Long id ){
		
		
		return bankService.deleteByAccountId(id);
		
	}
	
	
	
}
