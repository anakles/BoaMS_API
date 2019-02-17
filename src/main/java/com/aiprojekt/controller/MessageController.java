package com.aiprojekt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
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
}