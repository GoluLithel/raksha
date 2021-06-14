package com.raksha.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raksha.entity.Car;

public interface CarRepository extends JpaRepository<Car, String> {

}
