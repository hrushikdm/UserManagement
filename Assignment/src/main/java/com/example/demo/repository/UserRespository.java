package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.User;
/**
 * 
 * @author Hrushikesh Kadam
 *
 */

//user repository for database operation
public interface UserRespository  extends JpaRepository<User, Integer>{

}
