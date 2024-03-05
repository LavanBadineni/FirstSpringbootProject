package com.app.test;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.app.entity.BankAccount;
import com.app.entity.HardDisk;
import com.app.entity.Laptop;
import com.app.repository.BankAccountRepository;
import com.app.repository.HardDiskRepository;
import com.app.repository.LaptopRepository;

@SpringBootTest
public class BankAccountRepositoryTest {
	
	@Autowired
	private BankAccountRepository bankAccountRepository;
	
	@Autowired
	private HardDiskRepository hardkDiskRepository;
	
	@Autowired
	private LaptopRepository laptopRepository;
	
	/*
	 * @Test public void testSaveMethod() {
	 * 
	 * 
	 * BankAccount bankAccount = new BankAccount();
	 * bankAccount.setAccountHolderName("Ram"); bankAccount.setBalance(12345L);
	 * bankAccount.setMobileNumber("9090909090");
	 * 
	 * bankAccountRepository.save(bankAccount);
	 * 
	 * }
	 */
	
	  @Test 
	  public void testOnetoOne() {
	  
	  Laptop laptop=new Laptop(); laptop.setLaptopBrand("Lenovo");
	  laptop.setDiplayType("IPS");
	  
	  HardDisk hardDisk=new HardDisk(); hardDisk.setHardDiskBrand("Samsung");
	  hardDisk.setSize(500); hardDisk.setLaptop(laptop);
	  
	  hardkDiskRepository.save(hardDisk);
	  
	  
	  }
	 
	
	/*
	 * @Test public void getHardDisk() {
	 * 
	 * List<Laptop> allLaptops=laptopRepository.findAll();
	 * 
	 * System.out.println(allLaptops);
	 * 
	 * 
	 * 
	 * }
	 */
	
	


}
