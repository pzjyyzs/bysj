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
import com.yidu.lly.model.Like;
import com.yidu.lly.model.User;
import com.yidu.lly.service.FriendService;
import com.yidu.lly.service.LikeService;
import com.yidu.lly.service.UserService;

@Controller
@RequestMapping("/like")
public class LikeController {
	
	
	@Resource(name="likeServiceImpl")
	private LikeService likeService;
	

	public LikeService getLikeService() {
		return likeService;
	}

	public void setLikeService(LikeService likeService) {
		this.likeService = likeService;
	}
	
	
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
	
	//点赞
	@RequestMapping(value="/addLike.do", method = RequestMethod.GET)
	public String addLike(HttpServletRequest request,HttpSession session){
		String articleaid=request.getParameter("articleaid");
		String useruid=request.getParameter("useruid");
		
		Integer ArticleaId=Integer.parseInt(articleaid);
		Integer UseruId=Integer.parseInt(useruid);
		
		
		//status：1表示喜欢，0表示取消喜欢
	
		Like like=new Like();
		like.setUserid(UseruId);
		like.setArticleid(ArticleaId);
		
		if(null==this.likeService.selectLike(like)){
		
			this.likeService.insertLike(like);
			
		}
			return "redirect:/article/showArticleId.do?aid="+articleaid+"";
		
	}
	
	//取消点赞
	@RequestMapping(value="/delLike.do", method = RequestMethod.GET)
	public String delLike(HttpServletRequest request,HttpSession session){
		String articleaid=request.getParameter("articleaid");
		String useruid=request.getParameter("useruid");
		
		Integer ArticleaId=Integer.parseInt(articleaid);
		Integer UseruId=Integer.parseInt(useruid);
		
		
		//status：1表示喜欢，0表示取消喜欢
	
		Like like=new Like();
		like.setUserid(UseruId);
		like.setArticleid(ArticleaId);
		
		
		
			this.likeService.delLike(like);
			
			return "redirect:/article/showArticleId.do?aid="+articleaid+"";
	}
	
}
