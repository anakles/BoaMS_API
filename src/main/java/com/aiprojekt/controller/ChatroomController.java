package com.aiprojekt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import com.aiprojekt.services.ChatroomService;

@RestController
public class ChatroomController {
	
	 @Autowired
	 private ChatroomService chatroomService;
	 
	 //GET ALL:
	 @RequestMapping(value="/chatrooms", method = RequestMethod.GET)
	 public List getAllChatrooms() {
		 return chatroomService.getAllChatrooms();
	 }
}