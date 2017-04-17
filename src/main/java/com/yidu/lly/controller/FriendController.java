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










import com.yidu.lly.model.*;
import com.yidu.lly.service.ArticleService;
import com.yidu.lly.service.CommentService;
import com.yidu.lly.service.FriendService;
import com.yidu.lly.service.LikeService;
import com.yidu.lly.service.UserService;

@Controller
@RequestMapping("/friend")
public class FriendController {
	@Resource(name="articleServiceImpl")
	private ArticleService articleService;

	public ArticleService getArticleService() {
		return articleService;
	}

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
	@Resource(name="commentServiceImpl")
	private CommentService commentService;

	public CommentService getCommentService() {
		return commentService;
	}

	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}
	
	//显示好友列表
	//显示读友圈文章列表
	@RequestMapping(value="/showmyfriend.do", method = RequestMethod.GET)
	public String Tomyfriend(HttpServletRequest request,HttpSession session){
	
		User user=(User) session.getAttribute("user");
		
		//显示好友列表
		List<Friend> Friendlist =this.friendService.selectFriend(user);
		
		List<User>  Userlist=new ArrayList<User>();
		
		for (Friend friend : Friendlist) {    
		    Userlist.add( this.userService.selectUser(friend.getMid()));
		}  
		session.setAttribute("userlist", Userlist);
		
		//显示读友圈文章列表
		
		List<Articleinfomation> articlelist=new ArrayList<Articleinfomation>();
		
		for (User uitem: Userlist) {
			List<Article> userArticlelist=this.articleService.selectArticle(uitem.getUid());
			for(Article article:userArticlelist){
				Articleinfomation articleinfomation=new Articleinfomation();
				articleinfomation.setArticlename(article.getArticlename());
				articleinfomation.setArticlecontent(article.getArticlecontent());
				articleinfomation.setArticletime(article.getArticletime());
				articleinfomation.setUsername(uitem.getUsername());
				articleinfomation.setImg(uitem.getImg());
				
				articleinfomation.setComcount(commentService.selectountComent(article.getAid()));
				
				Like like=new Like();
				like.setArticleid(article.getAid());
				articleinfomation.setLikecount(likeService.selectountLike(like));
		    	
				articleinfomation.setUid(article.getUid());
				
				articlelist.add(articleinfomation);
		    	
		    }
		}
		
		session.setAttribute("articlelist", articlelist);
		
	/*	for(Article article:articlelist){
			System.out.println(article.getArticlename());
		}*/
		
		if(this.friendService.selectFriend(user).size()==0){
			return "none";
		}else{
			
		return "article/FriendAtList";
		}
	}
	//加关注
	@RequestMapping(value="/addfriend.do", method = RequestMethod.GET)
	public String addfriend(HttpServletRequest request,HttpSession session){
		User Userme=(User) session.getAttribute("user");
		String MyName=Userme.getUsername();
		String friendName=request.getParameter("username");
		
		
		Integer MyId=Userme.getUid();
		String friendId=request.getParameter("userid");
		Integer FriendId=Integer.parseInt(friendId);
		
		Friend myfriend=new Friend();

		myfriend.setMid(FriendId);
	    myfriend.setFid(MyId);	
		this.friendService.insertFriend(myfriend);
		return "redirect:/user/showOtheruser.do?userid="+friendId+"";
			
	}
	
	//取消关注
		@RequestMapping(value="/delfriend.do", method = RequestMethod.GET)
		public String delfriend(HttpServletRequest request,HttpSession session){
			User Userme=(User) session.getAttribute("user");
			String MyName=Userme.getUsername();
			Integer MyId=Userme.getUid();
			
			String friendName=request.getParameter("username");
			String friendId=request.getParameter("userid");
			Integer FriendId=Integer.parseInt(friendId);

			Friend myfriend=new Friend();
			
			myfriend.setMid(FriendId);
		    myfriend.setFid(MyId);	
			
			
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
					    Userlist.add( this.userService.selectUser(friend.getFid()));
					}  
					
					session.setAttribute("userlist", Userlist);
					
					return "message/MyFans";
				}		
				
	
	
}
