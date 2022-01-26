package com.moviebooking.dao;


import com.moviebooking.model.Role;

import com.moviebooking.model.User;

import java.util.List;

public interface UserDAO {

	public Integer registerNewUser(User user);

	public User loginUser(String emailId, String password, Role role);

	public Integer updateProfile(User user);

	public List <User> getUsers();


}
