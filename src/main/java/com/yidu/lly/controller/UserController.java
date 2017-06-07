package com.yidu.lly.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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



















import com.yidu.lly.model.*;
import com.yidu.lly.service.ArticleService;
import com.yidu.lly.service.CommentService;
import com.yidu.lly.service.FriendService;
import com.yidu.lly.service.LikeService;
import com.yidu.lly.service.RemindService;
import com.yidu.lly.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Resource(name="commentServiceImpl")
	private CommentService commentService;
	
	public CommentService getCommentService() {
		return commentService;
	}

	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
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
	
	@Resource(name="articleServiceImpl")
	private ArticleService articleService;
	
	public ArticleService getArticleService() {
		return articleService;
	}

	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}
	
	@Resource(name="remindServiceImpl")
	private RemindService remindService;
	
	public RemindService getRemindService() {
		return remindService;
	}

	public void setRemindService(RemindService remindService) {
		this.remindService = remindService;
	}
	
	//登录
	@RequestMapping(value="/showuser.do", method = RequestMethod.POST)
	public String toIndex(HttpServletRequest request,HttpSession session){
		User userLogin=new User();
		userLogin.setUsername(request.getParameter("username"));
		userLogin.setPassword(request.getParameter("password"));
		

		if(this.userService.selectUser(userLogin)!=null){
		  userLogin=this.userService.selectUser(userLogin);
		  List<Article> alist=null;
		  if(session.getAttribute("alist")==null){
			 alist=new ArrayList<Article>();
			 List<User> ulist=new ArrayList<User>();
			 List<Article> alistsub=new ArrayList<Article>();
			 Date date=new Date();
	  		 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	  		 Calendar call=Calendar.getInstance();
	  		 call.add(Calendar.DAY_OF_MONTH, +1);
	  		 String comtime=sdf.format(call.getTime());
	  		 Calendar cal=Calendar.getInstance();
	  		 cal.add(Calendar.DAY_OF_MONTH, -7);
	  		 String beforeCom=sdf.format(cal.getTime());
	         List<Like> likeList=this.likeService.showxihuan(beforeCom, comtime);
	         for (Like like : likeList) {
	        	  Article article=this.articleService.showArticleId( like.getArticleid());
	        	  alist.add(article);
	         }
	         
	         int zs=alist.size()/3;

	         int ys=alist.size()%3;
	         zs=(ys==0)?zs:zs+1;
	         if(zs==ys&&ys==0){
	        	 alistsub=alist;
	         }
	         else if(zs!=1){
	        	 alistsub=alist.subList(0,3);
	         }else{
	        	 alistsub=alist;
	         }
	         for(int i=0;i<alistsub.size();i++){
	  			 User u=this.userService.selectUser(alistsub.get(i).getUid());
	  			 ulist.add(u);
	         }
	         
	          session.setAttribute("alist", alist);
	          session.setAttribute("alistsub", alistsub);
	          session.setAttribute("ulist", ulist);
	          session.setAttribute("zs", zs);
	          session.setAttribute("count", zs);
		  }else{
			  alist=(List<Article>) session.getAttribute("alist");
			  List<User> ulist=(List<User>) session.getAttribute("ulist");
			  List<Article> alistsub=(List<Article>) session.getAttribute("alistsub");
			  int zs=(int) session.getAttribute("zs");
			  int count=(int) session.getAttribute("count");
			  session.setAttribute("alist", alist);
	          session.setAttribute("alistsub", alistsub);
	          session.setAttribute("ulist", ulist);
	          session.setAttribute("zs", zs);
	          session.setAttribute("count", zs);
		  }
		  session.setAttribute("user", userLogin);
		  
          
      	  return "index";
		}else{
			System.out.println("can not get user");
			session.setAttribute("error", "用户名或密码错误");
			return "login";
		}
	      
	}
	
	//注册
	@RequestMapping(value="/register.do",method= RequestMethod.POST)
	public String registerIndex(HttpServletRequest request,HttpSession session){
		
		User userRegister=new User();
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		userRegister.setUsername(username);
		userRegister.setPassword(password);
		
		this.userService.insertUser(userRegister);
		System.out.println("success register"+userRegister.getUsername());
		session.setAttribute("user", userRegister);
		return "index";
	}
	
	//检测用户名是否重复
	@RequestMapping(value="/findRegister.do",method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> findRegisterUserName(HttpServletRequest request,HttpServletResponse response){
		 String name=request.getParameter("registerUsername");
		 User userRegister=new User();
		 userRegister.setUsername(name);
		 Map<String,Object> map = new HashMap<String,Object>();
		 if(this.userService.selectUserName(userRegister)){
			 map.put("message", "用户名可用");
			 map.put("boo", true);
		 }else{
			 map.put("message", "该昵称已存在");
			 map.put("boo", false);
		 }
		 return map;
		 
	}
	@RequestMapping(value="/xljz.do",method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> xljz(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		 Map<String,Object> map = new HashMap<String,Object>();
		 String zss=request.getParameter("zs");
		 int zs=Integer.parseInt(zss);
		 int count=(int) session.getAttribute("count");
		 ArrayList<Article> alist=(ArrayList<Article>) session.getAttribute("alist");
		 ArrayList<Article> alistsub=new ArrayList<Article>();
		 ArrayList<User> ulist=(ArrayList<User>) session.getAttribute("ulist");
		
		 if(zs!=1&&alist.size()!=0){
			 int endCount=count*3-(zs-1)*3;
			 alistsub=(ArrayList<Article>) alist.subList(0, endCount);
		 }else{
			 alistsub=alist;
		 }
		 for(int i=0;i<alistsub.size();i++){
 			  User u=this.userService.selectUser(alistsub.get(i).getUid());
 			  ulist.add(u);
         }
		 session.setAttribute("alist", alist);
         session.setAttribute("alistsub", alistsub);
         session.setAttribute("ulist", ulist);
         session.setAttribute("zs", zs);
		 return map;
	}
	
	@RequestMapping(value="/ts.do",method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> ts(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		 Map<String,Object> map = new HashMap<String,Object>();
		 List<Article> alist=new ArrayList<Article>();
		 Date date=new Date();
  		 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
  		 Calendar call=Calendar.getInstance();
  		 call.add(Calendar.DAY_OF_MONTH, +1);
  		 String comtime=sdf.format(call.getTime());
  		 Calendar cal=Calendar.getInstance();
  		 cal.add(Calendar.DAY_OF_MONTH, -7);
  		 String beforeCom=sdf.format(cal.getTime());
         List<Like> likeList=this.likeService.showxihuan(beforeCom, comtime);
         for (Like like : likeList) {
       	  Article article=this.articleService.showArticleId( like.getArticleid());
       	  alist.add(article);
        }
        ArrayList<Article> al=(ArrayList<Article>) session.getAttribute("alist");
        int zs=(int) session.getAttribute("zs");
        int count=(int) session.getAttribute("count");
        if(al.size()==alist.size()){
        	map.put("temp", false);
        }else{
        	map.put("temp", true);
        }
        List<Article> alistsub=new ArrayList<Article>();
        ArrayList<User> ulist=(ArrayList<User>) session.getAttribute("ulist");
        if(zs!=1 &&alist.size()!=0){
			 int endCount=count*3-(zs-1)*3;
			 alistsub=  alist.subList(0, endCount);
		 }else{
			 alistsub=alist;
		 }
        for(int i=0;i<alistsub.size();i++){
			  User u=this.userService.selectUser(alistsub.get(i).getUid());
			  ulist.add(u);
       }
        session.setAttribute("alist", alist);
        session.setAttribute("alistsub", alistsub);
        session.setAttribute("ulist", ulist);
        session.setAttribute("zs", zs);
		return map;
	}
	//我的个人主页
	@RequestMapping(value="/showmyuser.do", method = RequestMethod.GET)
	public String Tomyuser(HttpServletRequest request,HttpSession session){
		    
		  User user=(User)session.getAttribute("user");
		   String UserName=user.getUsername();
		   
		   List<Friend> Friendlist1 =this.friendService.selectFriend(user);//查我所关注的人
		   int myfriend=0;//我所关注的人数
		   for (Friend friend : Friendlist1) {    
			   myfriend=myfriend+1;
			}  
		   
		   
		   List<Friend> Friendlist2 =this.friendService.selectMyFans(user);//查我的粉丝
		   int myfans=0;//我的粉丝数
		   for (Friend friend : Friendlist2) {    
			   myfans=myfans+1;
			}  
		   
		   
		   session.setAttribute("myfriend",myfriend);
		   session.setAttribute("myfans",myfans);
		   
	//我的文章内容：
		 
		   List<Article> myArticleList=this.articleService.selectArticle(user.getUid());
		   		   
		   List<Articleinfomation> MyArticleList=new ArrayList<Articleinfomation>();
		   
		   
		   int articlecount=0;
		   
		   for(Article article:myArticleList){
			   articlecount++;
			   Articleinfomation articleinfomation=new Articleinfomation();
			   articleinfomation.setArticlename(article.getArticlename());
				articleinfomation.setArticlecontent(article.getArticlecontent());
				articleinfomation.setArticletime(article.getArticletime());
				articleinfomation.setUsername(user.getUsername());
				articleinfomation.setImg(user.getImg());
				articleinfomation.setUid(user.getUid());
				articleinfomation.setAimgaddress(article.getAimgaddress());
				articleinfomation.setArticleread(article.getArticleread());
				articleinfomation.setComcount(commentService.selectountComent(article.getAid()));
				
				articleinfomation.setAid(article.getAid());
				
				Like like=new Like();
				like.setArticleid(article.getAid());
				articleinfomation.setLikecount(likeService.selectountLike(like));
				System.out.println(articleinfomation.getArticlename());
		  
				MyArticleList.add(articleinfomation);
		   }
		   
		   session.setAttribute("MyArticleList",MyArticleList);
		   session.setAttribute("articlecount",articlecount);
		   
      		return "indexuser";
	}
	
//编辑我的自我介绍
	@RequestMapping(value="/updateMyUser.do", method = RequestMethod.POST)
	public String updateMyUser(HttpServletRequest request,HttpSession session){
	         User userUpdate=(User) session.getAttribute("user");
		String myintr=request.getParameter("myintr");
		userUpdate.setUserintroduce(myintr);
		this.userService.updateUser(userUpdate);
		session.setAttribute("user", userUpdate);
      		return "indexuser";
	}
	
	//显示其他用户的个人主页
	@RequestMapping(value="/showOtheruser.do", method = RequestMethod.GET)
	public String ToOtherUser(HttpServletRequest request,HttpSession session){
		

		        String str=request.getParameter("userid");
			    int userid = Integer.parseInt(str);
			    
			    User myuser=(User)session.getAttribute("user");
			    if(userid==myuser.getUid()){
			    	return "redirect:/user/showmyuser.do?";
			    }
			    
			    User OtherUser=this.userService.selectUser(userid);
			    session.setAttribute("OtherUser", OtherUser);
			    
			    //统计关注人数和粉丝；
			    
			    List<Friend> Friendlist1 =this.friendService.selectFriend(OtherUser);//查所关注的人
				   int hisfriend=0;//我关注的人数
				   for (Friend friend : Friendlist1) {    
					   hisfriend=hisfriend+1;
					}  
				   
				   
				   List<Friend> Friendlist2 =this.friendService.selectMyFans(OtherUser);//查粉丝
				   int hisfans=0;//粉丝数
				   for (Friend friend : Friendlist2) {    
					   hisfans=hisfans+1;
					}  
				   
				   session.setAttribute("hisfriend",hisfriend);
				   session.setAttribute("hisfans",hisfans);

				   //判断是否隐藏关注按钮
				   User user=(User)session.getAttribute("user");
				    Integer MyId=user.getUid();
				    Integer friendId=OtherUser.getUid();
				    
				  
					Friend myfriend=new Friend();
					myfriend.setMid(friendId);
					myfriend.setFid(MyId);
					String str1="";
					String str2="";
					if(this.friendService.selectmyFriend(myfriend)!=null){
						str1="display:none";
						str2="";
						}else{
						str1="";
						str2="display:none";
						}
					session.setAttribute("str1", str1);
					session.setAttribute("str2", str2);
					
					
			//显示文章内容
					 List<Article> myArticleList=this.articleService.selectArticle(OtherUser.getUid());
			   		   
					   List<Articleinfomation> MyArticleList=new ArrayList<Articleinfomation>();
					   
					   
					   int articlecount=0;
					   
					   for(Article article:myArticleList){
						   articlecount++;
						   Articleinfomation articleinfomation=new Articleinfomation();
						   articleinfomation.setArticlename(article.getArticlename());
							articleinfomation.setArticlecontent(article.getArticlecontent());
							articleinfomation.setArticletime(article.getArticletime());
							articleinfomation.setUsername(OtherUser.getUsername());
							articleinfomation.setImg(OtherUser.getImg());
							articleinfomation.setUid(OtherUser.getUid());
							articleinfomation.setAimgaddress(article.getAimgaddress());
							articleinfomation.setArticleread(article.getArticleread());
							articleinfomation.setComcount(commentService.selectountComent(article.getAid()));
							
							articleinfomation.setAid(article.getAid());
							
							Like like=new Like();
							like.setArticleid(article.getAid());
							articleinfomation.setLikecount(likeService.selectountLike(like));
					  
							MyArticleList.add(articleinfomation);
					   }
					   
					   session.setAttribute("MyArticleList",MyArticleList);
					   session.setAttribute("articlecount",articlecount);
					
					return "OtherIndexUser";
	}
	
	
	
}
