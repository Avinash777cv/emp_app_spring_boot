package org.jsp.emp.exceptionclasses;

import lombok.Builder;

@Builder
public class NoEducationDataFoundException extends RuntimeException {

	private String message;
	
	public NoEducationDataFoundException(String message) {
		this.message=message;
	}
	
	@Override
	public String getMessage() {
		return this.message;
	}
}
