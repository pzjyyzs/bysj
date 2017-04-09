package com.yidu.lly.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.lly.mapper.FriendMapper;
import com.yidu.lly.mapper.UserMapper;
import com.yidu.lly.model.Friend;
import com.yidu.lly.model.User;
import com.yidu.lly.service.FriendService;
import com.yidu.lly.service.UserService;

@Service("FriendServiceImpl")
public class FriendServiceImpl implements FriendService{

	@Autowired
	private FriendMapper friendDao;

	@Override
	public List<Friend> selectFriend(User user) {
		// TODO Auto-generated method stub
		return this.friendDao.selectFriend(user);
	}


	@Override
	public void updateFriend(Friend friend) {
		// TODO Auto-generated method stub
		this.friendDao.updateFriend(friend);
	}

	@Override
	public void insertFriend(Friend friend) {
		// TODO Auto-generated method stub
		this.friendDao.insertFriend(friend);
	}


	@Override
	public Friend selectmyFriend(Friend friend) {
		// TODO Auto-generated method stub
		return this.friendDao.selectmyFriend(friend);
	}


	@Override
	public List<Friend> selectMyFans(User user) {
		// TODO Auto-generated method stub
		return this.friendDao.selectMyFans(user);
	}


	@Override
	public void delFriend(Friend friend) {
		this.friendDao.delFriend(friend);
		
	}


	

	

}
