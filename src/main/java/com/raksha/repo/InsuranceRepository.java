package com.raksha.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raksha.entity.Insurance;

public interface InsuranceRepository extends JpaRepository<Insurance, Integer> {

}
