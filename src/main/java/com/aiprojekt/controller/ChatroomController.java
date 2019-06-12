package com.aiprojekt.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aiprojekt.entities.Chatroom;
import com.aiprojekt.services.ChatroomService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value="Chatrooms")
public class ChatroomController {
	
	 @Autowired
	 private ChatroomService chatroomService;
	 
	 //GET ALL:
	 @ApiOperation(value="View all chatrooms available")
	 @RequestMapping(value="/chatrooms", method = RequestMethod.GET)
	 public List getAllChatrooms() {
		 return chatroomService.getAllChatrooms();
	 }
	 
	 //GET BY ID:
	 @ApiOperation(value="View the chatroom with given ID")
	 @RequestMapping(value="/chatrooms/{id}", method = RequestMethod.GET)
	 public Optional<Chatroom> getChatroom(@PathVariable String id){
		 return chatroomService.getChatroom(id);
	 }
	 
	//GET BY ID:
	@ApiOperation(value="Add a chatroom")
	@RequestMapping(value="/chatrooms", method = RequestMethod.POST)
	public ResponseEntity addChatroom(@RequestBody Chatroom chatroom){
		chatroomService.addChatroom(chatroom);
		return new ResponseEntity("Chatroom successfully added", HttpStatus.OK);
	}
	
	//GET BY ID:
	@ApiOperation(value="Edit a chatroom")
	@RequestMapping(value="/chatrooms/{id}", method = RequestMethod.PUT)
	public ResponseEntity updateChatroom(@PathVariable Long id, @RequestBody Chatroom chatroom){
		chatroomService.updateChatroom(id, chatroom);
		return new ResponseEntity("Chatroom successfully edited", HttpStatus.CONTINUE);
	}
	
	//tbd
	@ApiOperation(value="Add a user to a chatroom")
	@RequestMapping(value="/chatroom/{chatroom_id}/addUser/{user_id}", method = RequestMethod.PUT)
	public ResponseEntity updateChatroom_addUser(@PathVariable Long chatroom_id, @PathVariable Long user_id){
		chatroomService.addUserToChatroom(chatroom_id, user_id);
		return new ResponseEntity("Successfully added user to chatroom", HttpStatus.CONTINUE);
	}
	
	//GET BY ID:
	@Transactional
	@ApiOperation(value="Remove the chatroom with the given ID")
	@RequestMapping(value="/chatrooms/{id}", method = RequestMethod.DELETE)
	public ResponseEntity deleteChatroom(@PathVariable String id){
		chatroomService.deleteChatroom(id);
		return new ResponseEntity("Chatroom successfully deleted", HttpStatus.OK);
	}
		
		
		 
}