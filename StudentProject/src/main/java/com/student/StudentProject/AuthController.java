package com.student.StudentProject;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
	 @PostMapping("/authenticate")
	    public String generateToken(@RequestParam String username, @RequestParam String password) {
	        // Simple check, replace with DB validation
	        if ("student".equals(username) && "password".equals(password)) {
	            return JwtUtil.generateToken(username);
	        } else {
	            throw new RuntimeException("Invalid Credentials");
	        }
	    }
}


//token
//eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzdHVkZW50IiwiaWF0IjoxNzcwMDkxMTE2LCJleHAiOjE3NzAwOTQ3MTZ9.bkrlQC15QWM753F9SmFx8w5a56Du-loqn0BgdMYJDzU
