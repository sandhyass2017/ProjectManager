package com.cognizant.projectmanagement.task;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
	@Autowired
	public TaskRepository taskRepository;
	
	

	public List<Tasks> getTasksList() {
		List<Tasks> tasks = new ArrayList<>();
		taskRepository.findAll().forEach(tasks::add);
		return tasks;
	}
	
	@Transactional	
    public void updateProject(Tasks tasks, Integer task_id) {
		taskRepository.updateTask(tasks.getEndDate(),tasks.getParentTask(),tasks.getPriority(),tasks.getProject(),tasks.getStartDate(),tasks.getStatus(),tasks.getTask(),task_id);
   }
	
	public Tasks createProject(Tasks tasks) {
        return taskRepository.save(tasks);
    }
	public void deleteUser(Integer id) {
		taskRepository.delete(id);
	}
}