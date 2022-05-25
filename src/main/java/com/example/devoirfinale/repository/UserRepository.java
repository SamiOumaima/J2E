package com.example.devoirfinale.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.devoirfinale.model.User;


public interface UserRepository extends JpaRepository<User,Integer>{
	
	User findByUserName(String name);

}