package com.aiprojekt.repositories;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.aiprojekt.entities.Chatroom;

@Repository
public interface ChatroomRepository extends CrudRepository<Chatroom, String> {

	public Optional<Chatroom> findByChatroomId(long chatroomId);
	
	public void removeByChatroomId(long chatroomId);
	

}
