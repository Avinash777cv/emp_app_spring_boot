package org.jsp.emp.exceptionclasses;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class NoActiveEmployeeFoundException extends RuntimeException {

	private String message;
	
	public NoActiveEmployeeFoundException(String messsage) {
		this.message=messsage;
	}

	
	@Override
	public String getMessage() {
		
		return this.message;
	}
	
}
