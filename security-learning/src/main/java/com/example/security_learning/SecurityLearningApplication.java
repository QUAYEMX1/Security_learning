package com.example.security_learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SecurityLearningApplication {

	public static void main(String[] args) {

		String Password="abc";
		BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
		System.out.println(passwordEncoder.encode(Password));

		SpringApplication.run(SecurityLearningApplication.class, args);

	}


}
