package com.cognizant.projectmanagement.project;

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
@RequestMapping("project")
@CrossOrigin
public class ProjectController {
	
	@Autowired
	public ProjectService projectService;
	
	// View all project
		@RequestMapping(method = RequestMethod.GET)
		public ResponseEntity<List<Project>> getAllUser() {
			List<Project> projects = projectService.getProjectList();
			return new ResponseEntity<List<Project>>(projects, HttpStatus.OK);
		}

		// Add project
		@RequestMapping(method = RequestMethod.POST)
		public ResponseEntity<Project> createUser(@RequestBody Project project) {
			Project projectData = projectService.createProject(project);
			return new ResponseEntity<Project>(projectData, HttpStatus.OK);
		}

		// Edit all project
		@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
		public ResponseEntity<Project> updateUser(@RequestBody Project project, @PathVariable Integer id) {
			projectService.updateProject(project, id);
			return new ResponseEntity<Project>(HttpStatus.OK);
		}
		
		// Delete all project
		@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	    public ResponseEntity<String> deleteUser(@PathVariable Integer id) {
			projectService.deleteUser(id);        
	        return new ResponseEntity<String>("Success", HttpStatus.OK);
	    }
}
