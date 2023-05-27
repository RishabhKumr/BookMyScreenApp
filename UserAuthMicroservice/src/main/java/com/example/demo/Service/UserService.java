package com.example.demo.Service;

import java.util.List;

import com.example.demo.Model.User;

public interface UserService {
	public User addUser(User user);
	public boolean loginUser(String username,String password);
	public List<User> getAllUsers();
}
