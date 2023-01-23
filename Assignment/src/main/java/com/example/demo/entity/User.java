package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
/**
 * 
 * @author Hrushikesh Kadam
 *
 */

//creatating table in DB with below fields
@Data
@Entity
public class User {

	
	@Id
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private int age;
}
	