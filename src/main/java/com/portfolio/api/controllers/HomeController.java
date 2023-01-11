package com.portfolio.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	
	@GetMapping("/home/")
	public String home(@RequestParam(value = "name", defaultValue = "World") String name) {
		return "Hello " + name;
	}
    
}