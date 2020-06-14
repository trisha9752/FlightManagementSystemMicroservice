/****************************************************************************************************************************
 - File Name        : BookingExceptionController
 - Author           : Trisha Mazumdar
 - Creation Date    : 11-06-2020
 - Description      : This is an ExceptionController class to handle the Exception in Booking Services.
  ****************************************************************************************************************************/ 


package com.capgemini.flightmanagement.bookingservice.exception;

import java.util.HashMap;
import java.util.Map;

import javax.validation.ConstraintViolationException;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BookingExceptionController {
	
	@ExceptionHandler(BookingNotFoundException.class)
	public String handleException(BookingNotFoundException e) {
		
		return e.getMessage();
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public Map<String, String> handleConstraintViolation(ConstraintViolationException ex) {
	    Map<String, String> errors = new HashMap<>();
	     
	    ex.getConstraintViolations().forEach(cv -> {
	        errors.put("message", cv.getMessage());
	        errors.put("path", (cv.getPropertyPath()).toString());
	    }); 
	    return errors;
	}
}
