package com.student.StudentProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentservice;
	
	
	@PostMapping
	public ResponseEntity<?> createStudent(@RequestBody StudentModel student){
		return studentservice.createStudent(student);
	}
	
	@GetMapping
	public ResponseEntity<?> fetchStudent(){
		return studentservice.fetchStudents();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> fetchStudentById(@PathVariable int id){
		return studentservice.fetchStudentById(id);
	}
	
}
