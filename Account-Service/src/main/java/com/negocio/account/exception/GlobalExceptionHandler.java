package com.negocio.account.exception;

import javax.management.relation.RoleNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(RoleNotFoundException.class)
	public ResponseEntity<?> roleNotFound(String errorMessage) {
		return new ResponseEntity<String>(errorMessage, HttpStatus.NOT_FOUND);
	}
}
