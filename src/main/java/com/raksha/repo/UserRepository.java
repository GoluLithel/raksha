package com.raksha.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.raksha.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	 @Query("SELECT COUNT(u) FROM User u WHERE u.id=:id")
	 public long getUserCount(@Param("id")int id);


}
