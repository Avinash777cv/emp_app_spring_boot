package org.jsp.emp.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.emp.entity.Education;
import org.jsp.emp.repository.EducationRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class EducationDAO {
	
	EducationRepository repository;

	public Education saveEducation(Education education) {
		
		return repository.save(education);
	}

	public Optional<Education> findEducationById(int id) {
		
		return repository.findById(id);
	}

	public List<Education> findAllEducation() {
		
		return repository.findAll();
	}

	public Education updateEducation(Education education) {
		
		return repository.save(education);
	}
	
	

}
