package org.jsp.emp.entity;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Entity
@Data
public class Education {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String qualification;
	private String univarsityName;
	private double percentage;
	private int completionYear;
	private String highestQalification;
	@ManyToOne
	private Employee employee;
	

}
