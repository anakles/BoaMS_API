package com.aiprojekt.services;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aiprojekt.entities.Chatroom;
import com.aiprojekt.repositories.ChatroomRepository;
import java.util.List;
import java.util.Optional;

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
	
	public void updateChatroom(Chatroom chatroom) {
		chatroomRepository.save(chatroom);
	}
	
	public void deleteChatroom(String chatroom_id) {
		chatroomRepository.removeByChatroomId(Long.valueOf(chatroom_id));
	}
	
	
}
