package com.example.School_Project;

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
public class School {
	
	@Id
	@GeneratedValue
	private int id;
	
	
	private String schoolName;
	private String location;
	private String principalName;
	
}
