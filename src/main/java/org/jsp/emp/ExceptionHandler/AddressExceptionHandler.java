package org.jsp.emp.ExceptionHandler;

import org.jsp.emp.exceptionclasses.AddressNullException;
import org.jsp.emp.exceptionclasses.InvalidAddressIdException;
import org.jsp.emp.exceptionclasses.NoAddressFoundException;
import org.jsp.emp.responsestructure.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AddressExceptionHandler {
	
	@ExceptionHandler(NoAddressFoundException.class)
	public ResponseEntity<?> noAddressFoundException(NoAddressFoundException e){
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ResponseStructure.builder().status(HttpStatus.NOT_FOUND.value()).Body(e.getMessage()).build());
	}

	@ExceptionHandler(InvalidAddressIdException.class)
	public ResponseEntity<?> invalidAddressIdException(InvalidAddressIdException e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ResponseStructure.builder().status(HttpStatus.NOT_FOUND.value()).Body(e.getMessage()).build());
		
	}
	@ExceptionHandler(AddressNullException.class)
	public ResponseEntity<?> addressNullException(AddressNullException e){
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseStructure.builder().status(HttpStatus.BAD_REQUEST.value()).Body(e.getMessage()).build());
	}
	
	
}
