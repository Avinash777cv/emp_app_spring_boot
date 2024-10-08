package org.jsp.emp.ExceptionHandler;


import java.sql.SQLIntegrityConstraintViolationException;

import org.hibernate.query.NativeQuery.ReturnableResultNode;
import org.jsp.emp.exceptionclasses.InvalidEmpoleeIdException;
import org.jsp.emp.exceptionclasses.InvalideEmployeeCredentialException;
import org.jsp.emp.exceptionclasses.NoActiveEmployeeFoundException;
import org.jsp.emp.exceptionclasses.NoEmployeeFoundException;
import org.jsp.emp.responsestructure.ResponseStructure;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EmployeeExceptionHandle {
	
	
	@ExceptionHandler(NoActiveEmployeeFoundException.class)
	public ResponseEntity<ResponseStructure<String>> noActiveEmployeeFoundExceptionHandler(NoActiveEmployeeFoundException e) {
		
		ResponseStructure<String> structure=new ResponseStructure<>();
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setMessage("No Active Employee Found..");
		structure.setBody(e.getMessage());
		return  new ResponseEntity(structure, HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(InvalidEmpoleeIdException.class)
	public ResponseEntity<ResponseStructure<String >> invalidEmpoleeIdException(InvalidEmpoleeIdException e){
		

		ResponseStructure<String> structure=new ResponseStructure<>();
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setMessage("Invalid Id.... Employee Not Found..");
		structure.setBody(e.getMessage());
		return new ResponseEntity(structure, HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(InvalideEmployeeCredentialException.class)
	public ResponseEntity<ResponseStructure<String>> invalideEmployeeCredentialException( InvalideEmployeeCredentialException e){
		
		ResponseStructure<String> structure=new ResponseStructure<>();
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setMessage("Invalid Credential.... Employee Not Found...");
		structure.setBody(e.getMessage());
		return new ResponseEntity(structure, HttpStatus.NOT_FOUND);
		
	}

	@ExceptionHandler(NoEmployeeFoundException.class)
	public ResponseEntity<ResponseStructure<String>>  noEmployeeFoundExceptionHandler(NoEmployeeFoundException e){
		
		ResponseStructure<String> structure=new ResponseStructure<>();
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setMessage("NO Employee Found");
		structure.setBody(e.getMessage());
		return new ResponseEntity(structure, HttpStatus.OK);
	}
	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	public ResponseEntity<?> sQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException e){
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ResponseStructure.builder().status(HttpStatus.BAD_REQUEST.value()).message("duplicate email or phoneNumber").Body(e.getMessage()).build());	
		
	}

}

