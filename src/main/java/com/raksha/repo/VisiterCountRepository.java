package com.raksha.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.raksha.entity.VisiterCount;

public interface VisiterCountRepository extends JpaRepository<VisiterCount, Integer> {
	
//	@Query ("UPDATE VisiterCountResponse v SET userVisitedCount= userVisitedCount+1")
//	public void incrementCount();
	
	@Modifying
	@Transactional
	@Query("update VisiterCount v  set v.userVisitedCount = v.userVisitedCount + 1")
	public void incrementCount();

}
