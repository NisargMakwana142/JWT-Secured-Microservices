package com.student.StudentProject;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepo studentrepo;
	
	@Autowired 
	private RestTemplate restTemplate;
	
	public ResponseEntity<?> createStudent(StudentModel student){
		try {
			return new ResponseEntity<StudentModel>(studentrepo.save(student),HttpStatus.OK);
		}
		catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	public ResponseEntity<?> fetchStudentById(int id){
		Optional<StudentModel> student = studentrepo.findById(id);
		
		if(student.isPresent()) {
			School school =  restTemplate.getForObject("http://SCHOOLPROJECT/school/"+student.get().getSchoolId(),School.class);
			StudentResponse studentResponse = new StudentResponse(
					student.get().getId(),
					student.get().getName(),
					student.get().getAge(),
					student.get().getGender(),
					school
					);
			return new ResponseEntity<>(studentResponse,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("no student found",HttpStatus.NOT_FOUND);
		}
		
	}
	
	public ResponseEntity<?> fetchStudents(){
		List<StudentModel> student = studentrepo.findAll();
		
		if(student.size()>0) {
			return new ResponseEntity<List<StudentModel>>(student,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("no student found",HttpStatus.NOT_FOUND);
		}
	}
	 
}
