package com.cognizant.projectmanagement.user;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cognizant.projectmanagement.project.Project;
import com.cognizant.projectmanagement.task.Tasks;


public interface UserRepository extends CrudRepository<User, Integer>{
	 @Modifying
	    @Query("UPDATE User as US SET US.employeeId = :employeeId,US.firstName=:firstName,US.lastName=:lastName,US.projectId=:projectId,US.taskId=:taskId WHERE US.id= :userId")
	    void updateUser(@Param("employeeId") Integer employeeId, @Param("userId") Integer userId,@Param("firstName") String firstName,
	                    @Param("lastName") String lastName,@Param("projectId") Project projectId,@Param("taskId") Tasks taskId);

}
