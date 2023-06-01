package com.nt.errorhandler;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AllErrorHandler {

	@ExceptionHandler(Exception.class)
	public String errorHandler() {
		return "errorpage";
	}
}//end of the class AllErrorHandler
