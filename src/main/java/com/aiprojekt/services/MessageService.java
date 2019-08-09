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
	
	public Optional<Message> getMessage(long message_id) {
		return messageRepository.findByMessageId(Long.valueOf(message_id));
	}
	
	public List getMessagesByChatroom(long message_chatroom_id) {
		List messages = new ArrayList<>();
		messageRepository.findByMessageChatroomId(message_chatroom_id).forEach(messages::add);
		
		return messages;
	}
	
	public void addMessage(Message message) {
		messageRepository.save(message);
	}
	
	public void updateMessage(Long message_id, Message message) {
		
		Optional<Message> temp = messageRepository.findByMessageId(message_id);
		
		if(!temp.isPresent()) return;
		
		Message old_message = temp.get();
		
		//Compare attributes:
		if(!old_message.getMessage_txt().contentEquals(message.getMessage_txt()))
			old_message.setMessage_txt(message.getMessage_txt());
		//Don't change the other attributes
		
		
		messageRepository.save(old_message);
	}
	
	public void deleteMessage(Long message_id) {
		messageRepository.removeByMessageId(message_id);
	}
	
}
