package com.yidu.lly.mapper;

import com.yidu.lly.model.User;

public interface UserMapper {
	 public User selectUser(User user);
	 
	 public void insertUser(User user);
	 
	 public User selectUserName(User user);
}