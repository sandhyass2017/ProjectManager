package com.cognizant.projectmanagement.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

	@Autowired
	private UserService userService;

	// View all user
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> getAllUser() {
		List<User> userData = userService.getUserList();
		return new ResponseEntity<List<User>>(userData, HttpStatus.OK);
	}

	// View user by name
	@RequestMapping(method = RequestMethod.GET, value = "/userId/{userId}")
	public ResponseEntity<User> getUserByName(@PathVariable Integer userId) {
		User userData = userService.findUser(userId);
		return new ResponseEntity<User>(userData, HttpStatus.OK);
	}

	// Add user
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User userData = userService.createUser(user);
		return new ResponseEntity<User>(userData, HttpStatus.OK);
	}

	// Edit all user
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<String> updateUser(@RequestBody User user) {
		userService.updateUser(user);
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}

	// Delete all user
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Integer id) {
		userService.deleteUser(id);
		return new ResponseEntity<String>("Success", HttpStatus.OK);
	}
}
