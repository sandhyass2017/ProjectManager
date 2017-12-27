package com.cognizant.projectmanagement.task;

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
@RequestMapping("/task")
@CrossOrigin
public class TaskController {
	@Autowired
	public TaskService taskService;
	
	// View all task
		@RequestMapping(method = RequestMethod.GET)
		public ResponseEntity<List<Tasks>> getAllUser() {
			List<Tasks> projects = taskService.getTasksList();
			return new ResponseEntity<List<Tasks>>(projects, HttpStatus.OK);
		}

		// Add project
		@RequestMapping(method = RequestMethod.POST)
		public ResponseEntity<Tasks> createUser(@RequestBody Tasks project) {
			Tasks projectData = taskService.createProject(project);
			return new ResponseEntity<Tasks>(projectData, HttpStatus.OK);
		}

		// Edit all project
		@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
		public ResponseEntity<Tasks> updateUser(@RequestBody Tasks project, @PathVariable Integer id) {
			taskService.updateProject(project, id);
			return new ResponseEntity<Tasks>(HttpStatus.OK);
		}
		
		// Delete all project
		@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	    public ResponseEntity<String> deleteUser(@PathVariable Integer id) {
			taskService.deleteUser(id);        
	        return new ResponseEntity<String>("Success", HttpStatus.OK);
	    }
}
