package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;




	@RestController
	@CrossOrigin
	@RequestMapping("/apiusers/")
	public class UserController {

		@Autowired
		private UserService userService;

		// get all Users

		@GetMapping("/getUsers")
		public ResponseEntity<List<User>> getAllUsers() {
			return new ResponseEntity<List<User>>(userService.getAllUsers(), HttpStatus.OK);
		}

		// create user rest api
		@PostMapping("/createUsers")
		public ResponseEntity<User> createUser(@RequestBody User user) {
			return new ResponseEntity<User>(userService.createUser(user), HttpStatus.CREATED);

		}

		// get user by id Rest api
		@GetMapping("/getUsers/{id}")
		public ResponseEntity<User> getUserById(@PathVariable Long id) {
			User user = userService.getUserById(id);
			if (user != null) {
				return new ResponseEntity<User>(user, HttpStatus.OK);
			} else {
				return new ResponseEntity<User>(user, HttpStatus.NOT_FOUND);

			}

		}

		// get user by id Rest api
		@PostMapping("/users/login")
		public ResponseEntity<User> getUserEmailIdAndPassword(@RequestBody User user) {
			User user1 = userService.getUserEmailIdAndPassword(user);
			if (user1 != null) {
				return new ResponseEntity<User>(user1, HttpStatus.OK);
			} else {
				return new ResponseEntity<User>(user1, HttpStatus.NOT_FOUND);

			}

		}

		// Delete User by id Rest api
		@DeleteMapping("/deleteUsers/{id}")
		public ResponseEntity<String> deleteUser(@PathVariable Long id) {
			return new ResponseEntity<String>(userService.deleteUser(id), HttpStatus.OK);
		}

	}



