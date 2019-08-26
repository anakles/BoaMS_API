package com.aiprojekt.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aiprojekt.entities.Message;
import com.aiprojekt.services.MessageService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Api(value="Messages")
@RestController
public class MessageController {
	
	 @Autowired
	 private MessageService messageService;
	 
	 //GET ALL:
	 @ApiOperation(value="View all stored messages")
	 @RequestMapping(value="/messages", method = RequestMethod.GET)
	 public List getAllMessages() {
		 return messageService.getAllMessages();
	 }
	 
	//GET SINGLE MESSAGE BY ID:
	@ApiOperation(value="Get a message by its ID")
	@RequestMapping(value="/messages/{id}", method = RequestMethod.GET)
	public Optional<Message> getMessage(@PathVariable long id) {
		return messageService.getMessage(id);
	}
	
	//GET ALL MESSAGES BY A CHATROOM ID
	@ApiOperation(value="Get all messages from a chatroom ID")
	@RequestMapping(value="/messages/byChatroom/{id}", method = RequestMethod.GET)
	public List getMessagesByChatroom(@PathVariable long id) {
		return messageService.getMessagesByChatroom(id);
	}
	
	//CREATE:
	@ApiOperation(value="Create a message")
	@RequestMapping(value="/messages", method = RequestMethod.POST)
	public ResponseEntity<Message> addMessage(@RequestBody Message message) {
		messageService.addMessage(message);
		return new ResponseEntity(message, HttpStatus.CREATED);
	}
	
	
	//UPDATE BY ID:
	@ApiOperation(value="Edit the message with the given ID")
	@RequestMapping(value="/messages/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Message> updateMessage(@PathVariable Long id, @RequestBody Message message) {
		messageService.updateMessage(id, message);
		return new ResponseEntity(message, HttpStatus.CREATED);
	}
		
		
	//DELETE BY ID:
	@Transactional
	@ApiOperation(value="Delete the message with the given ID")
	@RequestMapping(value="/messages/{id}", method = RequestMethod.DELETE)
	public ResponseEntity deleteMessage(@PathVariable Long id) {
		messageService.deleteMessage(id);
		return new ResponseEntity("Message successfully deleted", HttpStatus.OK);
	}
	
	
	
	
	
}