package com.yidu.lly.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.lly.mapper.FriendMapper;
import com.yidu.lly.mapper.LikeMapper;
import com.yidu.lly.mapper.UserMapper;
import com.yidu.lly.model.Friend;
import com.yidu.lly.model.Like;
import com.yidu.lly.model.User;
import com.yidu.lly.service.FriendService;
import com.yidu.lly.service.LikeService;
import com.yidu.lly.service.UserService;

@Service("likeServiceImpl")
public class LikeServiceImpl implements LikeService{

	@Autowired
	private LikeMapper Likemapper;

	public void insertLike(Like like) {
				
		
		 this.Likemapper.insertLike(like);
		 
		// TODO Auto-generated method stub
		
	}

	public Like selectLike(Like like) {
		
		// TODO Auto-generated method stub
		return this.Likemapper.selectLike(like);
	}

	public Integer selectountLike(Like like) {
		// TODO Auto-generated method stub
		return this.Likemapper.selectountLike(like);
	}

	public void delLike(Like like) {
		// TODO Auto-generated method stub
		this.Likemapper.delLike(like);
	}

	
	public ArrayList<Like> showxihuan(String befortime, String aftertime) {
		// TODO Auto-generated method stub
		return this.Likemapper.showxihuan(befortime, aftertime);
	}

	

}
