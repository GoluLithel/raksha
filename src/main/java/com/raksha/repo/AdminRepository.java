package com.raksha.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.raksha.entity.Admin;


public interface AdminRepository extends JpaRepository<Admin, Integer> {

	 @Query("SELECT COUNT(u) FROM Admin u Where gmail=:mail")
	 public int emailCount(@Param("mail")String gmail);

	 @Query("SELECT COUNT(u) FROM Admin u Where mobileNo=:mobi")
	 public int mobileCount(@Param("mobi")String mobileNo);
	 
	 @Query("SELECT u.gmail FROM Admin u Where mobileNo=:mobi")
	 public String getEmail(@Param("mobi")String mobileNo);
	 
	 @Query("SELECT u.password FROM Admin u Where gmail=:mail")
	 public String getPassword(@Param("mail")String gmail);
	 
}
