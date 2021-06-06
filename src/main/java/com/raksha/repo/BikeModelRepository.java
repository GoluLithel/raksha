package com.raksha.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raksha.entity.BikeModel;

public interface BikeModelRepository extends JpaRepository<BikeModel, Integer> {

}
