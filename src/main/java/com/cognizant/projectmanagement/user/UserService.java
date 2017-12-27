package com.cognizant.projectmanagement.user;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;


@Service
public class UserService {
	@Autowired
	public UserRepository userRepository;

	public List<User> getUserList() {
		List<User> users = new ArrayList<>();
		userRepository.findAll().forEach(users::add);
		return users;
	}
	public User findUser(Integer userId) {
		return userRepository.findOne(userId);
	}
	
	
	@Transactional	
    public void updateUser(User user) {
     userRepository.save(user);
   }
	
	public User createUser(User user) {
        return userRepository.save(user);
    }
	
	@Transactional
	public void deleteUser(Integer id) {
		 userRepository.deleteUser(id);
	}
}
