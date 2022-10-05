package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@org.springframework.stereotype.Controller
public class Controller {
	
	@Autowired
	private Service service;
	
	
	@GetMapping("/register")
	public String getRegister(Model model) {
		model.addAttribute("registerRequest", new User());
		return "register_page";
	}
	@PostMapping("/register")
	public String register(@ModelAttribute User user) {
		User registerUser = service.registerUser(user.getUsername(), user.getPassword(), user.getEmail());
		return registerUser ==null ? "error_page" : "login_page";
	}
	
	@GetMapping("/login")
	public String getLogin(Model model) {
		model.addAttribute("loginRequest", new User());
		return "login_page";
	}
	@PostMapping("/login")
	public String login(@ModelAttribute User user) {
		User authenticated = service.authenticate(user.getUsername(), user.getPassword());
		
		return authenticated ==null ? "error_page" : "personal_page";
	}
	
	


	

}
