package com.aiprojekt.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aiprojekt.entities.User;
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
	
	public Optional<User> getUser(String user_id) {
		return userRepository.findById(user_id);
	}
	
	public void addUser(User user) {
		userRepository.save(user);
	}
	
	public void updateUser(String user_id, User user) {
		userRepository.save(user);
	}
	
}
