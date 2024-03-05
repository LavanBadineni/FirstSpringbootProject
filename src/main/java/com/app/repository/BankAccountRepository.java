package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.entity.BankAccount;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {
	
	public List<BankAccount> findBymobileNumber(String mobileNumber);
	
	public List<BankAccount> findByAccountHolderName(String accountHolderName);
	
	
	@Query("select bankAccountNumber from BankAccount b where mobileNumber=:mobileNumber")
	public String findAccountIdByMobileNumber(String mobileNumber);


	//@Query(nativeQuery = true,value = "select * from bank.bank_account")
	//public getthedata();
}
