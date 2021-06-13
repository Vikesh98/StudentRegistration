package com.vikesh.student.registration.controller;

import java.util.ArrayList;
import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vikesh.student.registration.model.Qualification;
import com.vikesh.student.registration.model.StudentsData;
import com.vikesh.student.registration.repository.QualificationRepository;
import com.vikesh.student.registration.repository.StudentsRepository;




@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class StudentRegistrationController {
	
	
	@Autowired
	private StudentsRepository studentRepository;
	
	@Autowired
	private QualificationRepository qualificationRepository;
	
	

	
	
	@GetMapping("/students")
	public List<StudentsData> getAllStudents() {
		return studentRepository.findAll();
	}
	
	@GetMapping("/qualification")
	public List<Qualification> getQualifications() {
		return qualificationRepository.findAll();
	}
	
	
	@PostMapping("/student")
	public StudentsData createStudent(@Valid @RequestBody StudentsData student) {
		return studentRepository.save(student);
		
	}

	
}
