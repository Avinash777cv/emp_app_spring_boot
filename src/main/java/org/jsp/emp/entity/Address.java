package org.jsp.emp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int doorNo;
	private String StreetAddress;
	private String addressLine2;
	private String city;
	private String state;
	private String country;
	private String postalCode;
	@ManyToOne
	private Employee employee;

}
