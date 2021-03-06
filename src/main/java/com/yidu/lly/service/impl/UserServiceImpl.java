package com.yidu.lly.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.lly.mapper.UserMapper;
import com.yidu.lly.model.User;
import com.yidu.lly.service.UserService;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userDao;

	public User selectUser(User user) {
		// TODO Auto-generated method stub
		return this.userDao.selectUser(user);
	}
	
	public User selectUser(String name) {
		// TODO Auto-generated method stub
		return this.userDao.selectmyUser(name);
	}
	

	public void insertUser(User user) {
		// TODO Auto-generated method stub
		this.userDao.insertUser(user);
	}
	
	public void updateUser(User user){
		this.userDao.updateUser(user);
	};

	public boolean selectUserName(User user) {
		User u=this.userDao.selectUserName(user);
		if(u==null){
			return true;
		}
		return false;
	}

	public User selectUser(int userid) {
		// TODO Auto-generated method stub
		return this.userDao.selectUserToid(userid);
	}


	

}
