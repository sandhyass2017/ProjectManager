package com.cognizant.projectmanagement.task;

import java.util.Date;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cognizant.projectmanagement.project.Project;

public interface TaskRepository extends CrudRepository<Tasks, Integer>{
	@Modifying
    @Query("UPDATE Tasks as TK SET TK.endDate = :endDate,TK.parentTask=:parentTask,TK.priority=:priority,TK.project=:project,TK.startDate=:startDate,TK.status=:status,TK.task=:task WHERE TK.taskId= :taskId")
    void updateTask(@Param("endDate") Date endDate, @Param("parentTask") ParentTask parentTask,@Param("priority") String priority,
                    @Param("project") Project project,@Param("startDate") Date startDate,@Param("status") String status,@Param("task") String task,@Param("taskId") Integer taskId);

}
