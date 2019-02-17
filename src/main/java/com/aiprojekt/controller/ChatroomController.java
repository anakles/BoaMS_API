package com.aiprojekt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
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
}