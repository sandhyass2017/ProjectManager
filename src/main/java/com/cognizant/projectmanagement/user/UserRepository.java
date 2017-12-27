package com.cognizant.projectmanagement.user;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


public interface UserRepository extends CrudRepository<User, Integer>{
	
	
	@Modifying
	@Query("DELETE FROM User US WHERE US.id=:userId")
    void deleteUser(@Param("userId") Integer userId);
}
