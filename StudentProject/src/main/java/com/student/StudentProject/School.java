package com.student.StudentProject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class School {
	
	private int id;
	private String schoolName;
	private String location;
	private String principalName;
	
}

//to get the response of school data in student services