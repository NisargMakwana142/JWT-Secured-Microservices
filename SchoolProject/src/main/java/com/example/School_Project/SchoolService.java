 package com.example.School_Project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SchoolService {
	
	@Autowired
	private SchoolRepo schoolRepo;
	
	public School AddSchool(School school) {
		return schoolRepo.saveAndFlush(school);
	}
	
	public List<School> GetAllData() {
		return schoolRepo.findAll();
	}
	
	public School GetDataById(int id) {
		return schoolRepo.findById(id).orElse(null);
	}
	
	
	
}
