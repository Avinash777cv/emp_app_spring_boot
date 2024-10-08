package org.jsp.emp.service;

import java.util.List;
import java.util.Optional;

import org.jsp.emp.dao.AddresssDAO;
import org.jsp.emp.dao.EmpolyeeDAO;
import org.jsp.emp.entity.Address;
import org.jsp.emp.entity.Employee;
import org.jsp.emp.exceptionclasses.AddressNullException;
import org.jsp.emp.exceptionclasses.InvalidAddressIdException;
import org.jsp.emp.exceptionclasses.InvalidEmpoleeIdException;
import org.jsp.emp.exceptionclasses.NoAddressFoundException;
import org.jsp.emp.responsestructure.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class AddressService {
	@Autowired
	AddresssDAO dao;
	EmpolyeeDAO employeedao;

	public ResponseEntity<?> saveEmployeeAdress(Address address) {
		
		return ResponseEntity.status(HttpStatus.CREATED).body(ResponseStructure.builder().status(HttpStatus.CREATED.value()).message("Addres added successfully...").Body(dao.saveEmployeeAddress(address)).build());
	}

	public ResponseEntity<?> findEmployeeAddress() {
		
	   List<Address> adl=dao.findEmployeeAddress();
		
		if(adl.isEmpty())
		throw NoAddressFoundException.builder().message("no addresses found...").build();
		else		
		return ResponseEntity.status(HttpStatus.FOUND).body(ResponseStructure.builder().status(HttpStatus.FOUND.value()).message("Address found successfully...").Body(adl));
	}

	public ResponseEntity<?> findAddressById(int id) {
		
	Optional<Address>	op=dao.findAddressById(id);
	
	if(op.isPresent())
		return ResponseEntity.status(HttpStatus.FOUND).body(ResponseStructure.builder().status(HttpStatus.FOUND.value()).message("Address found successfully...").Body(dao));
	else
		throw InvalidAddressIdException.builder().message("Invalid Id...Address not found").build();
	}

	public ResponseEntity<?> updateAdress(Address address) {
		
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("Address Update Successfully..").Body(dao.updateAddress(address)).build());
	}

	public ResponseEntity<?> deleteAddressById(int id) {
		
		Optional<Address> op=dao.findAddressById(id);
		if(op.isPresent()) {
		dao.deleteAddressById(id);
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("Address Deleted Successfully..").Body("Address deleted...").build());
		}
		else {
			
			throw InvalidAddressIdException.builder().message("Invalid Id...Address able to delete").build();
		}
	}

	public ResponseEntity<?> deleteAddressByEmplopyeeId(int id) {
		
		Optional<Employee> op = employeedao.findEmployeeById(id);
		if(op.isPresent()) {
			if(op.get()!=null) {
				dao.deleteAddressById(op.get().getAddress().getId());				
				return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("Address Deleted successfully..").Body("Address deleted...").build());				
			}
			else {
				throw AddressNullException.builder().message("Address is Null..Unble to delete..").build();
			}
			
		}
		else {
			
			throw InvalidEmpoleeIdException.builder().message("Invalid Employee Id...Address able to delete").build();
		}
	}

//	public ResponseEntity<?> updateAddressByEmployeeId(int id, Address address) {
//		Optional<Employee> op = employeedao.findEmployeeById(id);
//		if(op.isPresent()) {
//			
//			
//		}
//		
//		
//		return null;
	//}
	
	
	
	
	
	

}
