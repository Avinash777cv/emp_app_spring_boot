package org.jsp.emp.service;

import java.util.List;
import java.util.Optional;

import org.jsp.emp.dao.EducationDAO;
import org.jsp.emp.entity.Education;
import org.jsp.emp.exceptionclasses.InvalidEducationIdException;
import org.jsp.emp.exceptionclasses.NoEducationDataFoundException;
import org.jsp.emp.responsestructure.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class EducationService {
    @Autowired
	EducationDAO dao;
	
	public ResponseEntity<?> saveEducation(Education education) {
		
		return ResponseEntity.status(HttpStatus.CREATED).body(ResponseStructure.builder().status(HttpStatus.CREATED.value()).message("added educationdetail successfully").Body(dao.saveEducation(education)).build());
	}

	public ResponseEntity<?> findEducationById(int id) {
		Optional<Education> op = dao.findEducationById(id);
		if(op.isPresent())
		return ResponseEntity.status(HttpStatus.FOUND).body(ResponseStructure.builder().status(HttpStatus.FOUND.value()).message("Education found successfully...").Body(op.get()));
		else 		
	    throw InvalidEducationIdException.builder().message("Invalide id..education detailes not found").build();
	}

	public ResponseEntity<?> findAllEducation() {
		
		List<Education> edl=dao.findAllEducation();
		if(edl.isEmpty()) 			
			throw NoEducationDataFoundException.builder().message("No education detail found").build();
		else
		return ResponseEntity.status(HttpStatus.FOUND).body(ResponseStructure.builder().status(HttpStatus.FOUND.value()).message("details found Successfully..").Body(edl));
	}

	public ResponseEntity<?> updateEducation(Education education) {
		
		return ResponseEntity.status(HttpStatus.OK).body(ResponseStructure.builder().status(HttpStatus.OK.value()).message("updated successfully").Body(dao.updateEducation(education)).build());
	}

}
