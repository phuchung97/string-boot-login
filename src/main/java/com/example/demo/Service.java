package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class Service {
	
	@Autowired
	private Repository repo;
	
	public User registerUser(String username, String password, String email) {
		if(username ==null || password ==null || email ==null) {
			return null;
		}else {
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			user.setEmail(email);
			
			return repo.save(user);
		}
	}
	
	public User authenticate(String username, String password) {
		return repo.findByUsernameAndPassword(username, password);
	}

}
