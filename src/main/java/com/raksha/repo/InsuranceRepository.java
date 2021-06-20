package com.raksha.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.raksha.entity.Insurance;

public interface InsuranceRepository extends JpaRepository<Insurance, Integer> {
	
	@Query("FROM Insurance WHERE userId=:usrid")
	public List<Insurance> findInsuranceByUser(@Param("usrid")int userId);
	 
	@Query("SELECT COUNT(i) FROM Insurance i WHERE i.type=:type")
	public long getInsuranceTypeCount(@Param("type")String type);

	@Query("SELECT COUNT(i) FROM Insurance i WHERE i.vehicleType=:type")
	public long getInsuranceVehicleTypeCount(@Param("type")String type);
	 
//	 @Query("SELECT COUNT(i) FROM Insurance i WHERE i.type=:\'Comprehensive\'")
//	 public long getComprhensiveCount();

}
