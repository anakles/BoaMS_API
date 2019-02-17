package com.aiprojekt.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aiprojekt.entities.Message;

@Repository
public interface MessageRepository extends CrudRepository<Message, String> {

}