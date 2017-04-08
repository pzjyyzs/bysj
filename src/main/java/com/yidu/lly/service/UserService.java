package com.yidu.lly.service;

import com.yidu.lly.model.User;

public interface UserService {

	public User selectUser(User user);
	
	public User selectUser(String name);
	
	public void updateUser(User user);
	
	public void insertUser(User user);
	
	public boolean selectUserName(User user);
}
