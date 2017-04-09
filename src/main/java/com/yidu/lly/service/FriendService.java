package com.yidu.lly.service;

import java.util.List;



import com.yidu.lly.model.Friend;
import com.yidu.lly.model.User;


public interface FriendService {

 public List<Friend> selectFriend(User user);
 
 public List<Friend> selectMyFans(User user);
	 
	 public void updateFriend(Friend friend);
	 
	 public void delFriend(Friend friend);
	 
	 public void insertFriend(Friend friend);
	 
	 public Friend selectmyFriend(Friend friend);
}
