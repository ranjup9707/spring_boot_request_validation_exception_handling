package com.springboot.validationandexception.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.validationandexception.dto.UserRequest;
import com.springboot.validationandexception.entity.User;
import com.springboot.validationandexception.exception.UserNotFoundException;
import com.springboot.validationandexception.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;

	public User saveUser(UserRequest request) {
		User user = User.build(0, request.getName(), request.getEmail(), request.getMobile(), request.getGender(),request.getAge(), request.getNationality());
		return userRepo.save(user);
	}

	public List<User> fetchAllUser() {
		return userRepo.findAll();
	}

	public User getUser(int id) throws UserNotFoundException {
		User user = userRepo.findByUserId(id);
		if(user != null)
		{
			return user;
		}
		else
		{
			throw new UserNotFoundException("User not found");
		}
	}
}
