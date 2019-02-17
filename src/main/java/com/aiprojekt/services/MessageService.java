package com.aiprojekt.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aiprojekt.repositories.MessageRepository;

@Service
public class MessageService {

	@Autowired
	MessageRepository messageRepository;
	
	public List getAllMessages() {
		List messages = new ArrayList<>();
		messageRepository.findAll().forEach(messages::add);
		
		return messages;
	}
}
