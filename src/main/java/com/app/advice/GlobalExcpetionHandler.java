package com.app.advice;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import org.slf4j.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.app.exception.BankAccountNotFoundExcpetion;
import com.app.exception.InputInvalidExcpetion;

@RestControllerAdvice
public class GlobalExcpetionHandler {
	
	//private static final  logger = LoggerFactory.getLogger(GlobalExcpetionHandler.class);
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map handleMethodArgumentExcpetion(MethodArgumentNotValidException exception) {
		
		//ErrorVO errorVO=new ErrorVO();
		
		
		
		Map<String,String> allErrorMap=new HashMap<>();
	
		exception.getBindingResult().getFieldErrors().forEach(error->{
			allErrorMap.put(error.getField(), error.getDefaultMessage());
		}
		
		);
		
		return allErrorMap;
	}

	@ExceptionHandler(BankAccountNotFoundExcpetion.class)
	public ResponseEntity<ErrorVO> handleBankAccountNotFoundException(BankAccountNotFoundExcpetion ex) {
		ErrorVO errorVO=new ErrorVO();
		
		errorVO.setErrorCode(400);
		errorVO.setErrorMessage(ex.getMessage());
		
		return ResponseEntity.badRequest().body(errorVO);
	}
	
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<ErrorVO> handleNoSuchElementException(NoSuchElementException ex) {
		ErrorVO errorVO=new ErrorVO();
		
		errorVO.setErrorCode(400);
		errorVO.setErrorMessage(ex.getMessage());
		
		return ResponseEntity.badRequest().body(errorVO);
	}
	

	@ExceptionHandler(InputInvalidExcpetion.class)
	public ResponseEntity<ErrorVO> handleInputInvalidExcpetionException(InputInvalidExcpetion ex) {
		ErrorVO errorVO=new ErrorVO();
		
		errorVO.setErrorCode(400);
		errorVO.setErrorMessage(ex.getMessage());
		
		return ResponseEntity.badRequest().body(errorVO);
	}
}
