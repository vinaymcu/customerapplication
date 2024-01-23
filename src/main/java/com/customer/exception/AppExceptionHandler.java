package com.customer.exception;

import java.util.Date;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

/**
 * Global Exception handler class
 */
@Slf4j
@RestControllerAdvice
public class AppExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public final ResponseEntity<ErrorDetails> handleUserNotFoundException(ResourceNotFoundException ex,
																		  WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		log.info("inside AppExceptionHandler errorDetails:" + errorDetails);
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
}