package com.raksha.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.raksha.entity.BikeModel;

public interface BikeModelRepository extends JpaRepository<BikeModel, Integer> {
	
	@Query("FROM CarModel WHERE bikebrand=:brnd")
	public List<BikeModel> findModelByBrand(@Param("brnd")String bikebrand);

}
