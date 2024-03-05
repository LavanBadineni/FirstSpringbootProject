package com.app.service.impl;

import java.net.URI;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.client.RestTemplate;

import com.app.bean.BankAccountCreatedResponse;
import com.app.bean.BankAccountUpdateRequestVO;
import com.app.bean.BankAccountVO;
import com.app.bean.CreateAccountAPIRequest;
import com.app.bean.CreateAccountAPIResponse;
import com.app.dao.BankAccountDao;
import com.app.entity.BankAccount;
import com.app.exception.BankAccountNotFoundExcpetion;
import com.app.exception.InputInvalidExcpetion;
import com.app.service.BankAccountService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class BankAccountServiceImpl implements BankAccountService {
	
	private static final Logger logger = LoggerFactory.getLogger(BankAccountServiceImpl.class);
	
	@Autowired
	BankAccountDao bankAccountDao;

	@Override
	public BankAccountCreatedResponse createBankAccount( BankAccountVO bankAccountVO) {
		
		BankAccount bankAccount = new BankAccount();
		bankAccount.setAccountHolderName(bankAccountVO.getName());
		bankAccount.setBalance(bankAccountVO.getBalance());
		bankAccount.setMobileNumber(bankAccountVO.getMobileNumber());
		
		
		return bankAccountDao.save(bankAccount);
		
	}

	@Override
	public ResponseEntity<List<BankAccount>> getAllBankAccounts() {
		
		//System.out.println();
		
		return bankAccountDao.getAllBankAccounts();
	}

	@Override
	public void getDatafromRestApi() throws NoSuchAlgorithmException {
		
		RestTemplate restTemplate=new RestTemplate();
		
		Object s=restTemplate.getForObject("http://localhost:8080/bank/getAllBankAccounts", Object.class);
		
		List<BankAccount> ba=(List<BankAccount>)s;
		
		//System.out.println((List<BankAccount>)s);
		
		
		
	}

	@Override
	public CreateAccountAPIResponse createAccountUsingRestApi() {
	
		String payLoad=prepareRequest();
		
		logger.info("PayLoad for the createbankaccount api"+ payLoad);
		
		RestTemplate restTemplate=new RestTemplate();
		
		URI uri=URI.create("http://localhost:8080/bank/createBankAccount");
		
		HttpHeaders headers = new HttpHeaders();
		 headers.setContentType(MediaType.APPLICATION_JSON);
		 HttpEntity<String> entity = new HttpEntity<>(payLoad, headers);
		 
	 ResponseEntity<String> response=restTemplate.exchange(uri, HttpMethod.POST,entity , String.class);
		
		//ResponseEntity<String> response =restTemplate.postForEntity("http://localhost:8080/bank/createBankAccount", payLoad, String.class);
		
		String createApiResponse=response.getBody();
		logger.info("Response of  the createbankaccount api"+ createApiResponse);
		
		CreateAccountAPIResponse finalResponse=null;
		
		ObjectMapper objectMapper=new ObjectMapper();
		
		try {
			finalResponse=objectMapper.readValue(createApiResponse, CreateAccountAPIResponse.class);
		} catch (JsonMappingException e) {
			logger.error("Error while converting api response to java object");
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			logger.error("Error while converting api response to java object");
			e.printStackTrace();
		}
		
		return finalResponse;
	}

	private String prepareRequest() {
		
		String jsonRequest=null;
		
		CreateAccountAPIRequest request=new CreateAccountAPIRequest();
		
		request.setName("Test");
		request.setMobileNumber("9123912345");
		request.setBalance(12000L);
		
		ObjectMapper objectMapper=new ObjectMapper();
		try {
			jsonRequest=objectMapper.writeValueAsString(request);
		} catch (JsonProcessingException e) {
			logger.info("Error while converting java object to json string");
			e.printStackTrace();
		}
		
		
		return jsonRequest;
	}

	@Override
	public ResponseEntity<String> updateBankAccountById(BankAccountUpdateRequestVO request) throws BankAccountNotFoundExcpetion, InputInvalidExcpetion {
		
		
		if(request.getBankAccountNumber()==null) {
			throw new InputInvalidExcpetion("Please Input proper Value");
			
		}
		
		
		BankAccount bankAccount=bankAccountDao.getAccoutDetailsById(request.getBankAccountNumber());
		
		if(ObjectUtils.isEmpty(bankAccount)) {
			
			
			throw new BankAccountNotFoundExcpetion("Invalid Bank Account Number");
		}
		
		
		  if(request.getAccountHolderName()!=null) {
		  
		  bankAccount.setAccountHolderName(request.getAccountHolderName());
		  
		  }
			  
		if(request.getBalance()!=null) {
			  
			  
			  bankAccount.setBalance(request.getBalance());
		  }
		
		
		if(request.getMobileNumber()!=null) {
			  
			  bankAccount.setMobileNumber(request.getMobileNumber());
			  
		  }
		 
		
		  BankAccount bankAccountAfterUpdate= bankAccountDao.saveOrUpdate(bankAccount);
		
		  if(bankAccountAfterUpdate!=null) {
			  
			  return new ResponseEntity<String> ("Updated Successfully",HttpStatus.OK);
			  
		  }
		
		
		return  new ResponseEntity<String> ("Error while Updating your Request",HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	public ResponseEntity<String> deleteByAccountId(Long id) {
		
		if(id==null) {
			
			return  new ResponseEntity<String> ("Please input the Account Number",HttpStatus.BAD_REQUEST);
			
		}
		
		try {
			
			bankAccountDao.deleteByAccountId(id);
		}catch(Exception e) {
			
			
			return new ResponseEntity<String> ("Error while deleting",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		
		return new ResponseEntity<String> ("Deleted Successfully",HttpStatus.OK);
	}

}
