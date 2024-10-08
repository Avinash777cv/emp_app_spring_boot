package org.jsp.emp.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.emp.entity.Address;
import org.jsp.emp.entity.Employee;
import org.jsp.emp.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class AddresssDAO {
	
	@Autowired
	AddressRepository repository;

	public Address saveEmployeeAddress(Address address) {
		
		return repository.save(address);
	}

	public List<Address> findEmployeeAddress() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	public Optional<Address> findAddressById(int id) {
		
		return repository.findById(id);
	}

	public Address updateAddress(Address address) {
		
		return repository.save(address);
	}

	public void deleteAddressById(int id) {
		
		 repository.deleteById(id);
	}

	

	
}
