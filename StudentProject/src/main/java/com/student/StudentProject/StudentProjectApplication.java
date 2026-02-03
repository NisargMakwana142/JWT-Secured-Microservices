package com.student.StudentProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication

public class StudentProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentProjectApplication.class, args);
	}
	
	
	@Bean
	@LoadBalanced //it allows one microservices to call other using the service name instead of ip/url
	public RestTemplate restTemplate() {  //used to call other apis
		return new RestTemplate();		  //spring cannot inject (@autowired) an object unless it is a bean.
	}

}
