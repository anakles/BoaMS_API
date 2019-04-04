package com.aiprojekt.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aiprojekt.entities.Chatroom;
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
	
	public Optional<User> getUser(String userId) {
		return userRepository.findByUserId(Long.valueOf(userId));
	}
	
	public void addUser(User user) {
		userRepository.save(user);
	}
	
	public void updateUser(String user_id, User user) {
		userRepository.save(user);
	}
	
	public Optional<User> getUserByLoginName(String loginName) {
		return userRepository.findByLoginName(loginName);
	}
	
	public Set<Chatroom> getChatroomsOfUser(String userId) {
		Optional<User> user = userRepository.findByUserId(Long.valueOf(userId));
		return user.get().getChatrooms();
	}
	
}
