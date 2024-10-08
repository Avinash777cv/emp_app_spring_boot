package org.jsp.emp.exceptionclasses;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
public class NoAddressFoundException extends RuntimeException {
	
	private String message;
	

	public NoAddressFoundException(String message) {
		this.message=message;
		
	}
	
	@Override
	public String getMessage() {
		
		return this.message;
	}
	

}
