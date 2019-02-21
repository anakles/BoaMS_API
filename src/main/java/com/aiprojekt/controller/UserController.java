package com.aiprojekt.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aiprojekt.entities.User;
import com.aiprojekt.services.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="Users")
@RestController
public class UserController {
	
	 @Autowired
	 private UserService userService;
	 
	 //GET ALL:
	 @ApiOperation(value="View all users")
	 @RequestMapping(value="/users", method = RequestMethod.GET)
	 public List getAllUsers() {
		 return userService.getAllUsers();
	 }
	 
	//GET ONE BY ID:
	@ApiOperation(value="Find user by ID")
	@RequestMapping(value="/users/{id}", method = RequestMethod.GET)
	public Optional<User> getUser(@PathVariable String id) {
		return userService.getUser(id);
	}
	
	//ADD USER:
	@ApiOperation(value="Add a user")
	@RequestMapping(value="/users", method = RequestMethod.POST)
	public ResponseEntity addUser(@RequestBody User user) {
		userService.addUser(user);
		return new ResponseEntity("User successfully added", HttpStatus.CREATED);
	}
	
	//UPDATE USER BY ID:
	@ApiOperation(value="Editing a user")
	@RequestMapping(value="/users/{id}", method = RequestMethod.PUT)
	public ResponseEntity updateUser(@PathVariable String id, @RequestBody User user) {
		userService.updateUser(id, user);
		return new ResponseEntity("User successfully edited", HttpStatus.OK);
	}
}
