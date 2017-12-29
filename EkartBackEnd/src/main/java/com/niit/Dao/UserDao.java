package com.niit.Dao;

import java.util.List;

import com.niit.model.User;

public interface UserDao {
	public void insertUser(User user);
	public List<User> getAllUsers();

}
