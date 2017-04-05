package com.yidu.lly.controller;

import java.util.HashMap;
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

import com.yidu.lly.model.User;
import com.yidu.lly.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource(name="userServiceImpl")
	private UserService userService;
	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping(value="/showuser.do", method = RequestMethod.POST)
	public String toIndex(HttpServletRequest request,HttpSession session){
		User userLogin=new User();
		userLogin.setUsername(request.getParameter("username"));
		userLogin.setPassword(request.getParameter("password"));
		
		 User user=new User();

		if(this.userService.selectUser(userLogin)!=null){
		  userLogin=this.userService.selectUser(userLogin);
          System.out.println(user.toString()+"get user success");
          session.setAttribute("user", userLogin);
          
      		return "index";
		}else{
			System.out.println("can not get user");
			session.setAttribute("error", "用户名或密码错误");
			return "login";
		}
	      
	}
	
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
	
}
