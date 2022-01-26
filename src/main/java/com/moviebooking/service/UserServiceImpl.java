package com.moviebooking.service;



import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviebooking.dao.UserDAO;

import com.moviebooking.model.Role;

import com.moviebooking.model.User;
import com.moviebooking.validator.Validator;

import java.util.List;

@Service(value="userService")
@Transactional
public class UserServiceImpl implements UserService{
	@Autowired 
	private UserDAO userDAO;
	
	@Override
	public User loginUser(String emailId,String password, Role role) throws Exception{
		User user=null;
		user=userDAO.loginUser(emailId, password, role);
		System.out.println(role.getRoleName());
		if(user==null) {
			throw new Exception("UserService.INVALID_CREDENTIALS");
		}
		return user;
	}
	
	
	@Override
	public Integer registerNewUser(User user) throws Exception{		
		Validator.validateUser(user);
		Integer id=userDAO.registerNewUser(user);
		if(id==null) {
			throw new Exception("UserService.USER_ALREADY_EXISTS");
		}
		return id;
		
	}
	
	@Override
	public Integer updateProfile(User user) throws Exception{
		Integer id=userDAO.updateProfile(user);
		if(id==null) {
			throw new Exception("UserService.USER_NOT_EXISTS");
		}
		return id;
	}
	@Override
	public List<User> getUsers() throws Exception {
		System.out.println("hai from Service");
		List<User> userList = userDAO.getUsers();
		System.out.println(userList);
		if (userList==null) {
			throw new Exception("UserService.USER_NOT_EXISTS");
		}
		return userList;
	}
	

}
