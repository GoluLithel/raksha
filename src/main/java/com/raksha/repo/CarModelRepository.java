package com.raksha.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raksha.entity.CarModel;

public interface CarModelRepository extends JpaRepository<CarModel, Integer> {

}
