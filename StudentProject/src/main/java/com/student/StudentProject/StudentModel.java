package com.student.StudentProject;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


@Entity
public class StudentModel {
	
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private int age;
	private String gender;
	private Integer schoolId;
	
	
}
