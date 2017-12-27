package com.cognizant.projectmanagement.task;

import java.util.ArrayList;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public void updateTask(Tasks tasks,Integer id) {
		taskRepository.updateTask(tasks.getEndDate(),tasks.getParentTask(),tasks.getPriority(),tasks.getProject(),tasks.getStartDate(),tasks.getStatus(),tasks.getTask(),id);
   }
	
	public Tasks createTask(Tasks tasks) {
        return taskRepository.save(tasks);
    }
	@Transactional
	public void deleteTask(Integer id) {
		taskRepository.deleteTask(id);
	}
}
