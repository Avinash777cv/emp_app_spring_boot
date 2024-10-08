package org.jsp.emp.exceptionclasses;

import lombok.Builder;

@Builder
public class AddressNullException extends RuntimeException {

	private String message;
	
	public AddressNullException(String message) {
		this.message=message;		
	}
	
	@Override
	public String getMessage() {
		
		return this.message;
	}
}
