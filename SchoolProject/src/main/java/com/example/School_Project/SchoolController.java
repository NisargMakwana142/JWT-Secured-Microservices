package com.example.School_Project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("/school")
public class SchoolController {
	
	@Autowired
	private SchoolService schoolService;
	
	@PostMapping
	public School AddSchool(@RequestBody School school) {
		return schoolService.AddSchool(school);
	}
	
	@GetMapping   
	public List<School> GetAllData() {
		return schoolService.GetAllData();
	}
	
	@GetMapping("/{id}")
	public School GetDataById(@PathVariable int id) {
		return schoolService.GetDataById(id);
	}

}
