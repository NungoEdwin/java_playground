package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class TodoApplication {

	@GetMapping("/hello")
	public String getMethodName(@RequestParam(defaultValue="world", value="name") String param) {
		return String.format("Hello %s", param);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(TodoApplication.class, args);
	}

}
