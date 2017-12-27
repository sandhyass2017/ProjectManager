package com.cognizant.projectmanagement.user;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@Transactional	
    public void updateUser(User user, Integer user_id) {
     userRepository.updateUser(user.getEmployeeId(),user_id,user.getFirstName(),user.getLastName(),user.getProjectId(),user.getTaskId());
   }
	
	public User createUser(User user) {
        return userRepository.save(user);
    }
	public void deleteUser(Integer id) {
		 userRepository.delete(id);
	}
}
