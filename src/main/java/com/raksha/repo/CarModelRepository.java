package com.raksha.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.raksha.entity.CarModel;

public interface CarModelRepository extends JpaRepository<CarModel, Integer> {
	
	@Query("FROM CarModel WHERE brand=:brnd")
	public List<CarModel> findModelByBrand(@Param("brnd")String brand);
	
	@Query("FROM CarModel WHERE brand=:brnd AND model=:mdl")
	public List<CarModel> findVariantByBrandModel(@Param("brnd")String brand, @Param("mdl")String model);

//	@Query("Select cm.id FROM CarModel cm WHERE brand=:brnd AND model=:mdl AND variant=:var AND fuelType=:ft AND year=:yr")
//	public int findIdByDetails(@Param("brnd")String brand, @Param("mdl")String model, @Param("var")String variant, @Param("ft")String fuelType, @Param("yr")int year);
//	
	@Query("Select cm.id FROM CarModel cm WHERE Brand=:brnd AND model=:mdl AND variant=:var AND fuelType=:ft AND year=:yr")
	public int findIdByDetails(@Param("brnd")String brand, @Param("mdl")String model, @Param("var")String variant , @Param("ft")String fuelType, @Param("yr")int year);
	
}
