package com.yidu.lly.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

















import com.yidu.lly.model.Friend;
import com.yidu.lly.model.Mail;
import com.yidu.lly.model.User;
import com.yidu.lly.service.FriendService;
import com.yidu.lly.service.MailService;
import com.yidu.lly.service.UserService;

@Controller
@RequestMapping("/mail")
public class MailController {
	
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

	public void setMailService(MailService mailService) {
		MailService = mailService;
	}

	
	//写私信
	
		@RequestMapping(value="/writeMail.do", method = RequestMethod.POST)
		public @ResponseBody void writeMail(HttpServletRequest request,HttpSession session){
			String MyUserid=request.getParameter("MyUserid");
			String OtherUserid=request.getParameter("OtherUserid");
			
			
			Integer myUserid=Integer.parseInt(MyUserid);
			Integer otherUserid=Integer.parseInt(OtherUserid);
			
			String myMessage=request.getParameter("myMessage");

			Mail MyMail=new Mail();
		
		MyMail.setSendid(myUserid);
		MyMail.setReceiveid(otherUserid);
		MyMail.setCotent(myMessage);
			
				
		this.MailService.insertMail(MyMail);
		
		}
	
	
	//显示私信对象用户集合
	
	@RequestMapping(value="/showObjectUserList.do", method = RequestMethod.GET)
	public String ToObjectUserList(HttpServletRequest request,HttpSession session){
		
		User SendUser=(User) session.getAttribute("user");
		
		//收件箱集合
		List<Mail> ReceiveMaillist =this.MailService.selectReceiveMail(SendUser);
		
		
		//发件箱集合
        List<Mail> SendMaillist =this.MailService.selectSendMail(SendUser);
		
        //会话目标集合
        Set<Integer> set=new HashSet<Integer>(); 
        List<User> userlist=new ArrayList<User>();
			
			for(Mail mail:ReceiveMaillist){
				set.add(mail.getReceiveid());
			}
		
			for(Mail mail:SendMaillist){
				set.add(mail.getSendid());
			}
			
			Iterator<Integer> it =set.iterator();  
	        while(it.hasNext()){  
	        	userlist.add(this.userService.selectUser(it.next()));
	        }  
	        
	        
	        session.setAttribute("userlist", userlist);
	   
		  return "mail/userlist";
	}
	
	//显示会话内容
	
		@RequestMapping(value="/showSession.do", method = RequestMethod.GET)
		public String ToMessage(HttpServletRequest request,HttpSession session){
			
			User MyUser=(User) session.getAttribute("user");
			
			String  userid=request.getParameter("userid");
			
			
			 int OtherUserid = Integer.parseInt(userid);
			 
			 User OtherUser=this.userService.selectUser(OtherUserid);
			
			 
			 List<Mail> OurSession =this.MailService.selecteMail(MyUser,OtherUser);
		
			 
			 
			 session.setAttribute("OurSession", OurSession);
			 
			 session.setAttribute("OtherUser", OtherUser);
			 
			  return "mail/message";
		}
	
		//删除会话
		
			@RequestMapping(value="/delSession.do", method = RequestMethod.GET)
			public String delSession(HttpServletRequest request,HttpSession session){
				
				String userId1=request.getParameter("userId1");
				String userId2=request.getParameter("userId2");
				
				 int UserId1 = Integer.parseInt(userId1);
				 int UserId2 = Integer.parseInt(userId2);
				 
				 Mail mail1=new Mail();
                 Mail mail2=new Mail();
				 
                 mail1.setSendid(UserId1);
                 mail1.setReceiveid(UserId2);
                 
                 mail2.setSendid(UserId2);
                 mail2.setReceiveid(UserId1);
				 
                 
                 this.MailService.delMail(mail1);
                 this.MailService.delMail(mail2);
			   
				 return "redirect:/mail/showObjectUserList.do";
			}
		
			
		
			
			
	
}
