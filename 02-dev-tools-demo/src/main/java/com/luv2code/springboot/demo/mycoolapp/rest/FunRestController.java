package com.luv2code.springboot.demo.mycoolapp.rest;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;

public class FunRestController {

	//expose "/" to return "Hello World"
	
	@GetMapping("/")
	public String sayHello() {
		return "Hello  World! Time on server is "+LocalDateTime.now();
	}
	
	//expose a  new endpoint for "wokrout"
	@GetMapping("/workout")
	public String getDailyWokrout() {
		return "Run a hard 5k";
	}
	
	@GetMapping("/fortune")
	public String getDailyFortune() {
		return "Today is your lucky day";
	}
	
}
