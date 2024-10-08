package org.jsp.emp.exceptionclasses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
public class InvalidEmpoleeIdException extends RuntimeException {
	
	private String message;
	
	public InvalidEmpoleeIdException(String message) {
		
		this.message=message;
	}
	
	@Override
	public String getMessage() {
		
		return this.message;
	}
	

}
