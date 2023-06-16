package com.example.demo.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public User getUserById(long id) {
		User user = userRepository.findById(id).orElse(null);
		return user;
	}

	public User getUserEmailIdAndPassword(User user) {
		User user1 = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
		return user1;
	}

	public User updateUser(long id, User user) {
		User Userdetails = userRepository.save(user);
		return Userdetails;
	}

	
	public String deleteUser(long id) {
	userRepository.deleteById(id);
	return "Deleted";
	}

	public User createUser(User user) {
		return userRepository.save(user);
	}
}