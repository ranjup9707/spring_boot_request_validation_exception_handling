package com.springboot.validationandexception.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.validationandexception.dto.UserRequest;
import com.springboot.validationandexception.entity.User;
import com.springboot.validationandexception.exception.UserNotFoundException;
import com.springboot.validationandexception.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/addUser")
	public ResponseEntity<User> saveUser(@RequestBody @Valid UserRequest request){
		User user = userService.saveUser(request);
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}
	
	@GetMapping("/allUsers")
	public ResponseEntity<List<User>> getAllUser(){
		return ResponseEntity.ok(userService.fetchAllUser());
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUser(@PathVariable int id) throws UserNotFoundException{
		return ResponseEntity.ok(userService.getUser(id));
	}
	
}
