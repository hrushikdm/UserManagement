package com.example.demo.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRespository;

/**
 * 
 * @author Hrushikesh Kadam
 *
 */

//service layer for business logic
@Service
public class UserService {

	@Autowired
	private UserRespository userRespository;

	//get user by id
	public Optional<User> getById(int id) {
		return userRespository.findById(id);
	}

	
	//delete user by id
	public String deleteById(int id) {
		userRespository.deleteById(id);
		return "User deleted sucssfully";
		
	}

	
	//get all users
	public List<User> getAll() {
		return userRespository.findAll();
	}

	
	//save user
	public User save(User user) {
		return userRespository.save(user);
	}

	
	
	//update user
	public User update(User newUser) {

        User user
            = userRespository.findById(newUser.getId())
                  .get();
 
        if (Objects.nonNull(user.getFirstName())   &&   !"".equalsIgnoreCase( user.getFirstName())) {
            newUser.setFirstName(user.getFirstName());
        }
 
        else if (Objects.nonNull(user.getLastName())   &&   !"".equalsIgnoreCase( user.getLastName())) {
            newUser.setLastName(null);
        } 
        
        else  if (Objects.nonNull(user.getEmail())   &&   !"".equalsIgnoreCase( user.getEmail())) {
            newUser.setEmail(user.getEmail());
        }
        
        else  if (Objects.nonNull(user.getAge())) {
            newUser.setAge(user.getAge());
        }
        else   if (Objects.nonNull(user.getId())) {
            newUser.setId(user.getId());
        }
        return userRespository.save(newUser);
    }
}


