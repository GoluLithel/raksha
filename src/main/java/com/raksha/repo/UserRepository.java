package com.raksha.repo;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.raksha.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	 @Query("SELECT COUNT(u) FROM User u")
	 public long getUserCount();

	 @Query("SELECT COUNT(u) FROM User u Where gmail=:mail")
	 public int emailCount(@Param("mail")String gmail);

	 @Query("SELECT COUNT(u) FROM User u Where mobileNo=:mobi")
	 public int mobileCount(@Param("mobi")String mobileNo);
	 
	 @Query("SELECT u.gmail FROM User u Where mobileNo=:mobi")
	 public String getEmail(@Param("mobi")String mobileNo);
	 
	 @Query("SELECT u.id FROM User u  Where gmail=:mail")
	 public int getIdByEmail(@Param("mail")String gmail);
	 
//	 @Modifying
//	 @Transactional
//	 @Query("update User u  set u.fname = fn , u.mname = mn, u.lname = ln, u.gmail = mail, u.mobileNo = mobiNo, u.photoIdType = pit, u.photoId = u.pi  WHERE id := uid")
//	 public void updateUser(@Param("fn")String fname, @Param("mn")String mname, @Param("ln")String lname, @Param("mobiNo")String mobileNo, @Param("pit")String photoIdType, @Param("pi")String photoId, @Param("uid")int id );

}
