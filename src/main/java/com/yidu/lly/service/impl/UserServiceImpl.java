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

	@Override
	public User selectUser(User user) {
		// TODO Auto-generated method stub
		return this.userDao.selectUser(user);
	}

	@Override
	public void insertUser(User user) {
		// TODO Auto-generated method stub
		this.userDao.insertUser(user);
	}

	@Override
	public boolean selectUserName(User user) {
		User u=this.userDao.selectUserName(user);
		if(u==null){
			return true;
		}
		return false;
	}
	
	

}
