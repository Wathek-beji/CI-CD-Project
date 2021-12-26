package tn.esprit.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Dockertest {

	@GetMapping("/greeting")
	public String greet() {
		return "Hello from Docker";
	}
	
}
