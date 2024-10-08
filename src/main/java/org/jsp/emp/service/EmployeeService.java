package org.jsp.emp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.jsp.emp.EmployeeStatus;
import org.jsp.emp.dao.EmpolyeeDAO;
import org.jsp.emp.entity.Employee;
import org.jsp.emp.exceptionclasses.InvalidEmpoleeIdException;
import org.jsp.emp.exceptionclasses.InvalideEmployeeCredentialException;
import org.jsp.emp.exceptionclasses.NoActiveEmployeeFoundException;
import org.jsp.emp.exceptionclasses.NoEmployeeFoundException;
import org.jsp.emp.responsestructure.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class EmployeeService {

	@Autowired
	private EmpolyeeDAO dao;
	public ResponseEntity<?> saveEmployee(Employee employee) {
		employee.setStatus(EmployeeStatus.ACTIVE);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(ResponseStructure.builder().status(HttpStatus.CREATED.value()).message("Employee Saved Successfully...").Body(dao.saveEmployee(employee)).build());
	}
	public ResponseEntity<?> updateEmployee(Employee employee) {

		return ResponseEntity.status(HttpStatus.OK).body( ResponseStructure.builder().status(HttpStatus.OK.value()).message("Employee Updated Sucessfully...").Body(dao.updatedEmployee(employee)).build());
	}

	public ResponseStructure<Employee> findEmployeeById(int id) {
		Optional<Employee> optional = dao.findEmployeeById(id);
		ResponseStructure<Employee> structure = new ResponseStructure<>();
		if (optional.isEmpty())
			throw InvalidEmpoleeIdException.builder().message("Invalid Employee id...unable found Employee").build();
		

		Employee emp = optional.get();
		structure.setStatus(HttpStatus.FOUND.value());
		structure.setMessage("Employee Found Sucess");
		structure.setBody(emp);
		return structure;
	}

	public ResponseStructure<List<Employee>> findAllEmployees() {
		List<Employee> el = dao.findAllActiveEmployee();
		ResponseStructure<List<Employee>> structure = new ResponseStructure<>();
		if (el.isEmpty()) {
			
			throw new  NoActiveEmployeeFoundException("no active employee found in database table.....");
		}
		
//		ArrayList<Employee> activeEmployee=new ArrayList<>();
//		for(Employee e:el) {
//			
//			if(e.getStatus()==EmployeeStatus.ACTIVE) 
//			 activeEmployee.add(e);		
//				
//	}
		
		
		structure.setStatus(HttpStatus.FOUND.value());
		structure.setMessage("Employee Available");
		structure.setBody(el);
		return structure;
		
	}

	public ResponseStructure<String> deleteEmployeeById(int id) {
		Optional<Employee> op = dao.findEmployeeById(id);
		ResponseStructure<String> structure = new ResponseStructure<>();
		if (op.isEmpty()) {
			
			throw new InvalidEmpoleeIdException("Invalide Employee id...unable delete Employee");
			
		}
		dao.deleteEmployeeById(id);
		structure.setStatus(HttpStatus.OK.value());
		structure.setMessage("Employee Deleted");
		structure.setBody(null);
		return structure;
	}



	public ResponseStructure<List<Employee>> findEmployeeByName(String name) {
		ResponseStructure<List<Employee>> structure = new ResponseStructure<>();
		List<Employee> employees = dao.findEmployeeByName(name);

		if (employees.isEmpty())  
			throw new NoEmployeeFoundException("No Matching Employees Found for the Requested Name");
					
		structure.setStatus(HttpStatus.FOUND.value());
		structure.setMessage("Employee Available With" + name + "is");
		structure.setBody(employees);
		return structure;
	}
	public ResponseStructure<Employee> findEmployeeByEmailAndPassword(String email, String password) {

		Optional<Employee> el = dao.findEmployeeByEmailAndPassword(email,password);
		ResponseStructure<Employee> structure = new ResponseStructure<>();
		if (el.isEmpty()) {
			throw new InvalideEmployeeCredentialException("Invalide Credential.........");
		}
	Employee emp = el.get();
		structure.setStatus(HttpStatus.FOUND.value());
		structure.setMessage("Employee Available With");
		structure.setBody(emp);
		return structure;

	}
	public ResponseStructure<Employee> setEmployeeStausToActive(int id) {
		
		Optional<Employee> op = dao.findEmployeeById(id);
		ResponseStructure<Employee> structure=new ResponseStructure<>();
		
		if(op.isEmpty()) {
			throw new InvalidEmpoleeIdException("Invalide Employee id...unable to change EmployeeStatus as Active  ");
			
		}
		Employee e = op.get();
		e.setStatus(EmployeeStatus.ACTIVE);
		 e=dao.updatedEmployee(e);	
		
		structure.setStatus(HttpStatus.OK.value());
		structure.setMessage("employee status Updated to Active");
		structure.setBody(e);
		return structure;
	}
	public ResponseStructure<Employee> setEmployeeStatusToInActive(int id) {
		Optional<Employee> op = dao.findEmployeeById(id);
		ResponseStructure<Employee> structure=new ResponseStructure<>();
		
		if(op.isEmpty()) {
			throw new InvalidEmpoleeIdException("Invalide Employee id...unable to change EmployeeStatus as IN_Active  ");
			
		}
		Employee e = op.get();
		e.setStatus(EmployeeStatus.IN_ACTIVE);
		 e=dao.updatedEmployee(e);	
		
		structure.setStatus(HttpStatus.OK.value());
		structure.setMessage("employee status Updated to IN_Active");
		structure.setBody(e);
		return structure;
	}
	
	

}
