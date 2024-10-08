package org.jsp.emp.exceptionclasses;

import org.springframework.http.ResponseEntity;

import lombok.Builder;
@Builder
public class InvalidAddressIdException extends RuntimeException {
	
	private String message;
	
	public InvalidAddressIdException(String message) {
		this.message=message;
	}
	
	@Override
	public String getMessage() {
		
		return this.message;
	}
	

}
