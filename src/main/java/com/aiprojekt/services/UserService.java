package com.aiprojekt.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aiprojekt.entities.Chatroom;
import com.aiprojekt.entities.User;
import com.aiprojekt.repositories.ChatroomRepository;
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
	
	public Optional<User> getUser(Long userId) {
		return userRepository.findByUserId(userId);
	}
	
	public void addUser(User user) {
		userRepository.save(user);
	}
	
	public void updateUser(Long user_id, User user) {
		
		Optional<User> temp = userRepository.findByUserId(user_id);
		
		if(!temp.isPresent()) return;
		
		User old_user = temp.get();
		
		//Update attributes:
		if(!old_user.getDisplay_name().contentEquals(user.getDisplay_name()))
			old_user.setDisplay_name(user.getDisplay_name());
		
		if(!old_user.getLogin_name().contentEquals(user.getLogin_name()))
			old_user.setLogin_name(user.getLogin_name());
		
		userRepository.save(old_user);
	}
	
	public Optional<User> getUserByLoginName(String loginName) {
		return userRepository.findByLoginName(loginName);
	}
	
	public Set<Chatroom> getChatroomsOfUser(Long userId) {
		Optional<User> user = userRepository.findByUserId(userId);
		return user.get().getChatrooms();
	}
	
}
