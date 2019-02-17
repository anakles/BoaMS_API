package com.aiprojekt.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aiprojekt.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List getAllUsers() {
		List users = new ArrayList<>();
		userRepository.findAll().forEach(users::add);
		
		return users;		
	}
	
}
