package com.yidu.lly.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;





import com.yidu.lly.model.Article;
import com.yidu.lly.model.DyMail;
import com.yidu.lly.model.Friend;
import com.yidu.lly.model.Mail;
import com.yidu.lly.model.User;
import com.yidu.lly.service.ArticleService;
import com.yidu.lly.service.FriendService;
import com.yidu.lly.service.MailService;
import com.yidu.lly.service.UserService;

@Controller("jsonController")
@RequestMapping("/json")
public class JsonController {

	@Resource(name="userServiceImpl")
	private UserService userService;
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@Resource(name="MailServiceImpl")
	private MailService MailService;
	public MailService getMailService() {
		return MailService;
	}

	@RequestMapping(value="/flushSession.do", method = RequestMethod.GET)
    public @ResponseBody List<DyMail> showSession(HttpServletRequest request,HttpSession session){
		
		User MyUser=(User) session.getAttribute("user");
		
		String  userid=request.getParameter("userid");
		 int OtherUserid = Integer.parseInt(userid.trim());
		 
		 User OtherUser=this.userService.selectUser(OtherUserid);
		
		 
		 List<Mail> OurSession =this.MailService.selecteMail(MyUser,OtherUser);
		 
		 List<DyMail> OurDyMail=new ArrayList<DyMail>();
		 
		 for(Mail mail:OurSession){
			 DyMail dymail=new DyMail();
			 
			 dymail.setCreattime(mail.getCreattime());
			 dymail.setMid(mail.getMid());
			 dymail.setReceiveid(mail.getReceiveid());
			 dymail.setCotent( mail.getCotent());
			 dymail.setSendid(mail.getSendid());
			 dymail.setState(mail.getState());
			 
			 dymail.setUserid(MyUser.getUid());
			 dymail.setUsername(MyUser.getUsername());
			 dymail.setUserImg(MyUser.getImg());
			 
			 dymail.setOtherUserid(OtherUser.getUid());
			 dymail.setOtherUsername(OtherUser.getUsername());
			 dymail.setOtherUserImg(OtherUser.getImg());
			 
			 OurDyMail.add(dymail);			 
			/* System.out.println(dymail.getUsername());*/
		 }
		 session.setAttribute("OtherUser", OtherUser);
		  return OurDyMail;
	}
    
  
	
	
	
}