package org.jsp.crud_rest.exception;


import java.util.NoSuchElementException;

import org.jsp.crud_rest.helper.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MyExceptionHandler {
	@Autowired
	ResponseStructure<String> structure;
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<ResponseStructure<String>> handle(DataIntegrityViolationException exception){
		 structure.setMessage("Data can not be saved");
		 structure.setStatus(HttpStatus.BAD_REQUEST.value());
		 structure.setData("Mobile Number Already Exist");
		 
		 return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ArithmeticException.class)
	public ResponseEntity<ResponseStructure<String>> handle(ArithmeticException exception){
		 structure.setMessage("Data can not be saved");
		 structure.setStatus(HttpStatus.BAD_REQUEST.value());
		 structure.setData("We Can not divide number with zero");
		 
		 return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<ResponseStructure<String>> handle(NoSuchElementException exception){
		 structure.setMessage(exception.getMessage());
		 structure.setStatus(HttpStatus.NOT_FOUND.value());
		 structure.setData("No Data PResent");
		 
		 return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	}
}
