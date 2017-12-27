package com.cognizant.projectmanagement.project;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

	@Autowired
	public ProjectRepository projectRepository;
	
	

	public List<Project> getProjectList() {
		List<Project> projects = new ArrayList<>();
		projectRepository.findAll().forEach(projects::add);
		return projects;
	}
	
	@Transactional	
    public void updateProject(Project project, Integer user_id) {
		projectRepository.updateProject(project.getEndDate(),project.getId(),project.getPriority(),project.getProject(),project.getStartDate());
   }
	
	public Project createProject(Project project) {
        return projectRepository.save(project);
    }
	public void deleteUser(Integer id) {
		projectRepository.delete(id);
	}
	
}
