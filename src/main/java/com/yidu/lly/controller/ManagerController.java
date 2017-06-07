package com.yidu.lly.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yidu.lly.model.Article;
import com.yidu.lly.model.Manager;
import com.yidu.lly.service.CommentService;
import com.yidu.lly.service.ManagerService;


@Controller
@RequestMapping("/manager")

public class ManagerController {
	
	@Resource(name="managerServiceImpl")
	private ManagerService managerService;
	
	
	
	public ManagerService getManagerService() {
		return managerService;
	}



	public void setManagerService(ManagerService managerService) {
		this.managerService = managerService;
	}



		//登录
		@RequestMapping(value="/showmanager.do", method = RequestMethod.POST)
		public String toIndex(HttpServletRequest request,HttpSession session){
			Manager managerLogin=new Manager();
			managerLogin.setManagername(request.getParameter("managername"));
			managerLogin.setPassword(request.getParameter("password"));
			

			if(this.managerService.selectManager(managerLogin)!=null){
			
				managerLogin=this.managerService.selectManager(managerLogin);
			    
	          session.setAttribute("manager", managerLogin);
	         
	      	  return "background/index";
			}else{
				System.out.println("can not get user");
				session.setAttribute("error", "用户名或密码错误");
				return "background/login";
			}
		      
		}

}
