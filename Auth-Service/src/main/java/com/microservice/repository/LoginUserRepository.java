package com.microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.entities.LoginUser;

@Repository
public interface LoginUserRepository extends JpaRepository<LoginUser, Long>{

}
