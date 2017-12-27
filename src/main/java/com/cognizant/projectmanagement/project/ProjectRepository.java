package com.cognizant.projectmanagement.project;

import java.util.Date;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface ProjectRepository extends CrudRepository<Project, Integer>  {
	@Modifying
    @Query("UPDATE Project as PJ SET PJ.endDate=:endDate,PJ.priority=:priority,PJ.project=:project,PJ.startDate=:startDate WHERE PJ.id= :projectId")
	void updateProject (@Param("endDate") Date employeeId, @Param("projectId") Integer projectId,@Param("priority") String priority,
	                     @Param("project") String project,@Param("startDate") Date startDate);
	 

}
