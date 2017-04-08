package com.yidu.lly.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;




import com.yidu.lly.model.Friend;
import com.yidu.lly.model.User;
import com.yidu.lly.service.FriendService;
import com.yidu.lly.service.UserService;

@Controller
@RequestMapping("/friend")
public class FriendController {
	
	@Resource(name="userServiceImpl")
	private UserService userService;
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@Resource(name="FriendServiceImpl")
	private FriendService friendService;
	
	public FriendService getFriendService() {
		return friendService;
	}

	public void setFriendService(FriendService friendService) {
		this.friendService = friendService;
	}
	
	
	@RequestMapping(value="/showmyfriend.do", method = RequestMethod.GET)
	public String Tomyfriend(HttpServletRequest request,HttpSession session){
		User user=(User) session.getAttribute("user");
		
		List<Friend> Friendlist =this.friendService.selectFriend(user);
		
		List<User>  Userlist=new ArrayList<User>();
		
		for (Friend friend : Friendlist) {    
		    Userlist.add( this.userService.selectUser(friend.getFname()));
		}  
		for (User user1 : Userlist) {    
		   System.out.println(user1.getUid()+user1.getUsername());
		}  
		
		return "MyFriend";
	}
	
	
}
