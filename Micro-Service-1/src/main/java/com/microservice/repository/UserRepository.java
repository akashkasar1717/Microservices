package com.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
}
