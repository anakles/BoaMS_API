package com.aiprojekt.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aiprojekt.entities.Message;

@Repository
public interface MessageRepository extends CrudRepository<Message, String> {

	public Optional<Message> findByMessageId(long messageId);
	
	public void removeByMessageId(long messageId);

	
}
