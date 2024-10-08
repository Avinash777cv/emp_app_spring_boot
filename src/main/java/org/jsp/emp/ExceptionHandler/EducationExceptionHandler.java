package org.jsp.emp.ExceptionHandler;

import org.jsp.emp.exceptionclasses.InvalidEducationIdException;
import org.jsp.emp.exceptionclasses.NoEducationDataFoundException;
import org.jsp.emp.responsestructure.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EducationExceptionHandler {
	
	@ExceptionHandler(InvalidEducationIdException.class)
	public ResponseEntity<?> invalidEducationIdException(InvalidEducationIdException e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ResponseStructure.builder().status(HttpStatus.NOT_FOUND.value()).Body(e.getMessage()).build());
	}
	
	@ExceptionHandler(NoEducationDataFoundException.class)
	public ResponseEntity<?> noEducationDataFoundException(NoEducationDataFoundException e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ResponseStructure.builder().status(HttpStatus.NOT_FOUND.value()).message("education details is empty in database table").build());
	}

}
