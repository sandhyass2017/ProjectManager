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
		public ResponseEntity<List<Tasks>> getAllTasks() {
			List<Tasks> tasks = taskService.getTasksList();
			return new ResponseEntity<List<Tasks>>(tasks, HttpStatus.OK);
		}

		// Add task
		@RequestMapping(method = RequestMethod.POST)
		public ResponseEntity<Tasks> createTask(@RequestBody Tasks tasks) {
			Tasks taskData = taskService.createTask(tasks);
			return new ResponseEntity<Tasks>(taskData, HttpStatus.OK);
		}

		// Edit all task
		@RequestMapping(method = RequestMethod.PUT,value="/{id}")
		public ResponseEntity<String> updateTask(@RequestBody Tasks tasks,@PathVariable Integer id) {
			taskService.updateTask(tasks,id);
			return new ResponseEntity<String>("Success", HttpStatus.OK);
		}
		
		// Delete all task
		@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	    public ResponseEntity<String> deleteTask(@PathVariable Integer id) {
			taskService.deleteTask(id);        
	        return new ResponseEntity<String>("Success", HttpStatus.OK);
	    }
}
