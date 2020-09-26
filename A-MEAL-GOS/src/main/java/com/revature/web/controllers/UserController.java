package com.revature.web.controllers;

import com.revature.models.AppUser;
import com.revature.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// @RestController
// 		implies @Controller at the class level
// 		@Responsebody on the return type of each mapping method.
@RestController
@RequestMapping("/users")
public class UserController {

	private UserService userService;

	@Autowired
	public UserController(UserService service){
		this.userService = service;
	}

	// produces is good practice to include.
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<AppUser> getAllUsers(){
		return userService.getAllUser();
	}

	@GetMapping(value = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public AppUser getUserById(@PathVariable int id){
		return userService.getUserById(id);
	}

	@GetMapping(value = "/search")
	public AppUser getUserByUsername(@RequestParam String username){
		return userService.getUserByUsername(username);
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public AppUser registerUser(@RequestBody AppUser newUser){
		return userService.register(newUser);
	}







}