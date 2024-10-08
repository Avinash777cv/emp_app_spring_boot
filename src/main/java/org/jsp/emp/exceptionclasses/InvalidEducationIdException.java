package org.jsp.emp.exceptionclasses;

import lombok.Builder;

@Builder
public class InvalidEducationIdException extends RuntimeException {
	
	private String message;
	
	public InvalidEducationIdException(String message) {
		this.message=message;
	}
	
	@Override
	public String getMessage() {
		
		return this.message;
	}

}
