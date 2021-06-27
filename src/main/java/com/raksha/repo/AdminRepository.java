package com.raksha.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raksha.entity.Admin;


public interface AdminRepository extends JpaRepository<Admin, Integer> {

}
