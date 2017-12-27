package com.cognizant.projectmanagement.task;

import java.util.Date;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cognizant.projectmanagement.project.Project;

public interface TaskRepository extends CrudRepository<Tasks, Integer>{
	
	@Modifying
	@Query("DELETE FROM Tasks TK WHERE TK.id=:taskId")
    void deleteTask(@Param("taskId") Integer taskId);
	
	
	@Query("SELECT count(US.taskId) FROM User US WHERE US.taskId=:taskId")
	int noOfTasks(@Param("taskId") Integer taskId);
	
	@Modifying
    @Query("UPDATE Tasks as TK SET TK.endDate = :endDate,TK.parentTask=:parentTask,TK.priority=:priority,TK.project=:project,TK.startDate=:startDate,TK.status=:status,TK.task=:task WHERE TK.taskId= :taskId")
    void updateTask(@Param("endDate") Date date, @Param("parentTask") ParentTask parentTask,@Param("priority") String priority,
                    @Param("project") Project project,@Param("startDate") Date date2,@Param("status") String status,@Param("task") String task,@Param("taskId") Integer taskId);

	
	
}
