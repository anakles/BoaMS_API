package com.aiprojekt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import com.aiprojekt.services.UserService;

@RestController
public class UserController {
	
	 @Autowired
	 private UserService userService;
	 
	 //GET ALL:
	 @RequestMapping(value="/users", method = RequestMethod.GET)
	 public List getAllUsers() {
		 return userService.getAllUsers();
	 }
}