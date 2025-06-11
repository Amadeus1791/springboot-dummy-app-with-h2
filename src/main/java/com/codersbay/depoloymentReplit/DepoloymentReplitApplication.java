package com.codersbay.depoloymentReplit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DepoloymentReplitApplication implements CommandLineRunner {
	@Autowired
	private StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(DepoloymentReplitApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Student student = new Student("test", "a", 20);
		studentRepository.save(student);
		System.out.println(student);
	}
}
