package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;

@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public User addUser(User user) {
		if(user != null) {
			return userRepo.saveAndFlush(user);
		}
		return null;
	}

	@Override
	public boolean loginUser(String username, String password) {
		User user1 = userRepo.validateUser(username, password);
		if(user1 != null) {
			return true;
		}
		return false;
	}

	@Override
	public List<User> getAllUsers(){
		List<User> userList = userRepo.findAll();
		if(userList!=null & userList.size() > 0) {
			return userList;
		}
		else
			return null;
	}
}


