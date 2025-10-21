package com.example.demo;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class TodoApplication {
	private String template = "Hello, %s!";
	private AtomicLong counter = new AtomicLong();

	@GetMapping("/hello")
	public Hello getMethodName(@RequestParam(defaultValue="world", value="name") String param) {
		//return String.format("Hello %s", param);
		return new Hello(String.format(template,param));
	}
	
	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
	//record is a DTO(POJO) like data struct for immutable data 
	public record Greeting(long is,String content){}
	public record Hello(String content){}
	
	
	public static void main(String[] args) {
		SpringApplication.run(TodoApplication.class, args);
	}

}
