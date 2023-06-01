package com.nt.customexception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.nt.entity.Error;

@RestControllerAdvice
public class ErrorDetails {

	@ExceptionHandler(Exception.class) //instead of Exception.class we can take explicitly other exception also
	public ResponseEntity<Object> errorHandler(Exception e){
		//create a error object with argument
		Error err = new Error(LocalDateTime.now(),e.getMessage(),HttpStatus.NOT_FOUND);
		//return ResponseEntity
		return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
	}
}//end of the error class
