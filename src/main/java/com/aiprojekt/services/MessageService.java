package com.aiprojekt.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.aiprojekt.entities.Message;
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
	
	public Optional<Message> getMessage(String message_id) {
		return messageRepository.findById(message_id);
	}
	
	public void addMessage(Message message) {
		messageRepository.save(message);
	}
	
	public void updateMessage(String message_id, Message message) {
		messageRepository.save(message);
	}
	
	public void deleteMessage(String message_id) {
		messageRepository.deleteById(message_id);
	}
	
}
