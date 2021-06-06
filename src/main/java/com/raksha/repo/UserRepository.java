package com.raksha.repo;

import org.springframework.data.jpa.repository.JpaRepository;


import com.raksha.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
