package com.yidu.lly.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

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
	
	//显示好友列表
	@RequestMapping(value="/showmyfriend.do", method = RequestMethod.GET)
	public String Tomyfriend(HttpServletRequest request,HttpSession session){
		User user=(User) session.getAttribute("user");
		
		List<Friend> Friendlist =this.friendService.selectFriend(user);
		
		List<User>  Userlist=new ArrayList<User>();
		
		for (Friend friend : Friendlist) {    
		    Userlist.add( this.userService.selectUser(friend.getMname()));
		}  
		
		session.setAttribute("userlist", Userlist);
		
		return "MyFriend";
	}
	//加关注
	@RequestMapping(value="/addfriend.do", method = RequestMethod.GET)
	public String addfriend(HttpServletRequest request,HttpSession session){
		User Userme=(User) session.getAttribute("user");
		String MyName=Userme.getUsername();
		String friendName=request.getParameter("username");
		
		String friendId=request.getParameter("userid");
		
		Friend myfriend=new Friend();
		myfriend.setMname(friendName);
		myfriend.setFname(MyName);
		
		this.friendService.insertFriend(myfriend);
		return "redirect:/user/showOtheruser.do?userid="+friendId+"";
			
	}
	
	//取消关注
		@RequestMapping(value="/delfriend.do", method = RequestMethod.GET)
		public String delfriend(HttpServletRequest request,HttpSession session){
			User Userme=(User) session.getAttribute("user");
			String MyName=Userme.getUsername();
			String friendName=request.getParameter("username");
			
			String friendId=request.getParameter("userid");
			

			Friend myfriend=new Friend();
			myfriend.setMname(friendName);
			myfriend.setFname(MyName);
			
		    this.friendService.delFriend(myfriend);
			return "redirect:/user/showOtheruser.do?userid="+friendId+"";
				
		}
		
		//显示粉丝列表
				@RequestMapping(value="/showmyfans.do", method = RequestMethod.GET)
				public String showmyfans(HttpServletRequest request,HttpSession session){
					User user=(User) session.getAttribute("user");
					
					List<Friend> Friendlist =this.friendService.selectMyFans(user);
					
					List<User>  Userlist=new ArrayList<User>();
					
					for (Friend friend : Friendlist) {    
					    Userlist.add( this.userService.selectUser(friend.getFname()));
					}  
					
					session.setAttribute("userlist", Userlist);
					
					return "message/MyFans";
				}		
				
	
	
}
