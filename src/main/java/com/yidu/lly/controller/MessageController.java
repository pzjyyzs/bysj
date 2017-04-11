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
@RequestMapping("/Message")
public class MessageController {
	
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

	
	//显示消息页面
	
		@RequestMapping(value="/ToMessage.do", method = RequestMethod.GET)
		public String ToMessage(HttpServletRequest request,HttpSession session){
		
	  return "message/MessageIndex";
	  
		}
}
