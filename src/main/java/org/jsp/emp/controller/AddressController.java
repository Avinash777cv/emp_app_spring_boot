package org.jsp.emp.controller;

import org.jsp.emp.entity.Address;
import org.jsp.emp.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/addresses")
public class AddressController {
	@Autowired
	AddressService service;
	
	@PostMapping
	public ResponseEntity<?> saveEmployeeAdress(@RequestBody Address address){
		
		return service.saveEmployeeAdress(address);		
		
	}
	
	@GetMapping
	public ResponseEntity<?> findAllAddress(){
		
		return service.findEmployeeAddress();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findAddressById(@PathVariable int id){
		
		return service.findAddressById(id);
	}
	
	@PutMapping
	public ResponseEntity<?> updateAddress(@RequestBody Address address){
		
		return service.updateAdress(address);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteAddressById(@RequestParam int id){
		return service.deleteAddressById(id);
	}
	
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<?> deleteAddressByEmployeeId(@RequestParam int id){
		
		return service.deleteAddressByEmplopyeeId(id);
	}
//	@PutMapping("/employee/{id}")
//	public ResponseEntity<?> updateAddressByEmployeeId(@PathVariable int id, @RequestBody Address address){
//		return service.updateAddressByEmployeeId(id,address);
//	}
	

}
