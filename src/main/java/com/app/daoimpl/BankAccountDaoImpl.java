package com.app.daoimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.app.bean.BankAccountCreatedResponse;
import com.app.dao.BankAccountDao;
import com.app.entity.BankAccount;
import com.app.repository.BankAccountRepository;

@Repository
public class BankAccountDaoImpl implements BankAccountDao {
	
	@Autowired
	BankAccountRepository bankAccountRepository;

	@Override
	public BankAccountCreatedResponse save(BankAccount bankAccount) {
		
		BankAccount bankAccountResposne=bankAccountRepository.save(bankAccount);
		
		BankAccountCreatedResponse response=new BankAccountCreatedResponse();
		
	   response.setAccountNumber(bankAccountResposne.getBankAccountNumber());
	   response.setMessage("Account Created Successfully with Account Numner : "+bankAccountResposne.getBankAccountNumber());
	   response.setResponseCode(200);
		
		
	   return response;
		
		
	}

	@Override
	public ResponseEntity<List<BankAccount>> getAllBankAccounts() {
		
		
		System.out.println(bankAccountRepository.findAccountIdByMobileNumber("9999999999"));
		
	//	System.out.println(bankAccountRepository.findByAccountHolderName("bandineni"));
		
		 List<BankAccount> allBankAccounts=bankAccountRepository.findBymobileNumber("9999999999");
		 //List<BankAccount> allBankAccounts=bankAccountRepository.findAll();
		return new ResponseEntity<List<BankAccount>>(allBankAccounts,HttpStatus.OK);
	}

	@Override
	public BankAccount getAccoutDetailsById(Long bankAccountNumber) {
		
		Optional<BankAccount> bankAccount=bankAccountRepository.findById(bankAccountNumber);
		
		return bankAccount.get();
		
		
	}

	@Override
	public BankAccount saveOrUpdate(BankAccount bankAccount) {
		
		BankAccount bankAccountAfterUpdate=bankAccountRepository.save(bankAccount);
		
		
		return bankAccountAfterUpdate;
	}

	@Override
	public void deleteByAccountId(Long accountNumber) {
	
		bankAccountRepository.deleteById(accountNumber);
		
	}

	
	

}
