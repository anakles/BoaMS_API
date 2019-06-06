package com.aiprojekt.services;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aiprojekt.entities.Chatroom;
import com.aiprojekt.entities.User;
import com.aiprojekt.repositories.ChatroomRepository;
import java.util.List;
import java.util.Optional;

import javax.jws.soap.SOAPBinding.Use;

@Service
public class ChatroomService {

	@Autowired
	ChatroomRepository chatroomRepository;
	
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
	
	public void deleteChatroom(String chatroom_id) {
		chatroomRepository.removeByChatroomId(Long.valueOf(chatroom_id));
	}
	
	
}
