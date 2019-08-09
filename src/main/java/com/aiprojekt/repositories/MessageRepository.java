package com.aiprojekt.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aiprojekt.entities.Message;

@Repository
public interface MessageRepository extends CrudRepository<Message, String> {

	public Optional<Message> findByMessageId(long messageId);
	
	public List<Message> findByMessageChatroomId(long messageChatroomId);
	
	public void removeByMessageId(long messageId);

	
}
