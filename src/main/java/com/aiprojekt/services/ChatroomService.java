package com.aiprojekt.services;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aiprojekt.entities.Chatroom;
import com.aiprojekt.entities.User;
import com.aiprojekt.repositories.ChatroomRepository;
import com.aiprojekt.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

import javax.jws.soap.SOAPBinding.Use;
import javax.transaction.Transactional;
import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

@Service
public class ChatroomService {

	@Autowired
	ChatroomRepository chatroomRepository;
	
	@Autowired
	UserRepository userRepository;
	
	public List getAllChatrooms() {
		List chatrooms = new ArrayList<>();
		chatroomRepository.findAll().forEach(chatrooms::add);
		
		return chatrooms;	
	}
	
	public Optional<Chatroom> getChatroom(String chatroom_id){
		return chatroomRepository.findByChatroomId(Long.valueOf(chatroom_id));
	}
	
	public void addChatroom(Chatroom chatroom) {
		chatroomRepository.save(chatroom);
		addUserToChatroom(chatroom.getChatroom_id(), chatroom.getChatroom_owner_id());
	}
	
	public void updateChatroom(Long id, Chatroom chatroom) {
		
		//chatroomRepository.save(chatroom);
		Optional<Chatroom> temp = chatroomRepository.findByChatroomId(id);
		
		if(!temp.isPresent()) return;
		
		
		//Remove the entity from the repository, if exists:
		Chatroom old_chatroom = temp.get();
					
		//Changing the attributes:
		//Chatroom_name
		if(!old_chatroom.getChatroom_name().contentEquals(chatroom.getChatroom_name())){
			old_chatroom.setChatroom_name(chatroom.getChatroom_name());
		}
		//chatroom_owner_id
		if(old_chatroom.getChatroom_owner_id() != chatroom.getChatroom_owner_id()) {
			old_chatroom.setChatroom_owner_id(chatroom.getChatroom_owner_id());
		}
		//Always keep the users!
	
		
		//Adding the "changed" entity to the repository
		chatroomRepository.save(old_chatroom);
		
	
	}


	public void addUserToChatroom(Long chatroom_id, Long user_id) {
		Optional<Chatroom> temp = chatroomRepository.findByChatroomId(chatroom_id);
		if(!temp.isPresent()) return;
		Chatroom old_chatroom = temp.get();
		
		Optional<User> temp_user = userRepository.findByUserId(user_id);
		if(!temp_user.isPresent()) return;
		User old_user = temp_user.get();
		
		//Adding the user to the chatroom and the chatroom to the user
		old_chatroom.addUser(old_user);
		
		chatroomRepository.save(old_chatroom);
		userRepository.save(old_user);
				
	}
	
	public boolean removeUserFromChatroom(Long chatroom_id, Long user_id) {
		Optional<Chatroom> temp = chatroomRepository.findByChatroomId(chatroom_id);
		if(!temp.isPresent()) return false;
		Chatroom old_chatroom = temp.get();
		
		Optional<User> temp_user = userRepository.findByUserId(user_id);
		if(!temp_user.isPresent()) return false;
		User old_user = temp_user.get();
		
		//Removing chatroom from user and user from chatroom:
		boolean success = old_chatroom.removeUser(old_user);
		
		chatroomRepository.save(old_chatroom);
		userRepository.save(old_user);
		
		return success;
	}
	
	public void deleteChatroom(Long chatroom_id) {
		//chatroomRepository.removeByChatroomId(Long.valueOf(chatroom_id));
		//Remove all users from this chatroom:
		Optional<Chatroom> old_chatroom = chatroomRepository.findByChatroomId(chatroom_id);
		
		if(!old_chatroom.isPresent()) return;
		
		old_chatroom.get().clearUsers();
		
		chatroomRepository.save(old_chatroom.get());
		
	}
	
	
}
