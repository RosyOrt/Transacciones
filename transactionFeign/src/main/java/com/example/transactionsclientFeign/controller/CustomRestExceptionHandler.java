package com.example.transactionsclientFeign.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import exception.TransactionNotFoundException;
import structureRequest.ExceptionResponse;


@ControllerAdvice
@RestController
public class CustomRestExceptionHandler extends ResponseEntityExceptionHandler  {

	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> HanddleAllExceptions(Exception ex, WebRequest request){
		
		ExceptionResponse exceptionResponse 
		= new ExceptionResponse(ex.getClass().getName(), HttpStatus.INTERNAL_SERVER_ERROR.toString(), ex.getLocalizedMessage(), request.getDescription(false));
		
		return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(TransactionNotFoundException.class)
	public final ResponseEntity<Object> HanddleNoCoincidenceException(Exception ex, WebRequest request){
		
		ExceptionResponse exceptionResponse 
		= new ExceptionResponse(ex.getClass().getName(), HttpStatus.NOT_FOUND.toString(), ex.getLocalizedMessage(), request.getDescription(false));
		
		
		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request){
		 Map<String, String> errors = new HashMap<>();
	    ex.getBindingResult().getAllErrors().forEach((error) -> {
	        String fieldName = ((FieldError) error).getField();
	        String errorMessage = error.getDefaultMessage();
	        errors.put(fieldName, errorMessage);
	    });
	    
		ExceptionResponse exceptionResponse 
		= new ExceptionResponse(ex.getClass().getName(), HttpStatus.BAD_REQUEST.toString(), ex.getStackTrace()[0].getClassName()+"."+ ex.getStackTrace()[0].getMethodName(), errors.toString());
		
		
		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
	
	

}
