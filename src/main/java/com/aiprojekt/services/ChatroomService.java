package com.aiprojekt.services;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aiprojekt.repositories.ChatroomRepository;
import java.util.List;

@Service
public class ChatroomService {

	@Autowired
	ChatroomRepository chatroomRepository;
	
	public List getAllChatrooms() {
		List chatrooms = new ArrayList<>();
		chatroomRepository.findAll().forEach(chatrooms::add);
		
		return chatrooms;	
	}
}
