package com.raksha.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raksha.entity.Bike;

public interface BikeRepository extends JpaRepository<Bike, String> {

}
