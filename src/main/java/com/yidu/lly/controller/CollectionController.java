package com.yidu.lly.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.yidu.lly.model.Collection;
import com.yidu.lly.model.User;
import com.yidu.lly.service.impl.CollectionServiceImpl;

@Controller
@RequestMapping("/collection")
public class CollectionController {

	@Resource(name="collectionServiceImpl")
	private CollectionServiceImpl collectionServiceImpl;

	public CollectionServiceImpl getCollectionServiceImpl() {
		return collectionServiceImpl;
	}

	public void setCollectionServiceImpl(CollectionServiceImpl collectionServiceImpl) {
		this.collectionServiceImpl = collectionServiceImpl;
	}
	
	@RequestMapping(value="/addcollection.do", method = RequestMethod.POST)
	public String addCollection(HttpServletRequest request,HttpSession session){
		User user=(User) session.getAttribute("user");
		
		String collectionName=request.getParameter("nick-name");
		String collectionIntroduce=request.getParameter("nick-content");
		String collectionimg=request.getParameter("nick-img");
		int cid = (int) new Date().getTime()+user.getUid();
		Collection collection=new Collection();
		collection.setCid(cid);
		collection.setCollectionname(collectionName);
		collection.setCollectionintroduce(collectionIntroduce);
		collection.setCollectionimg(collectionimg);
		collection.setUid(user.getUid());
		//this.collectionServiceImpl.addCollection(collection);
		return "redirect:showcollection.do?cid="+cid;
	}
	
	@RequestMapping(value="showcollection.do",method=RequestMethod.GET)
	public String showCollection(HttpServletRequest request,HttpSession session,int cid){
		System.out.println(cid);
		return "index";
	}
	
	@RequestMapping(value="/collectionImage.do",method=RequestMethod.POST)
	public String  editTbReportImage(@RequestParam("reportFile") CommonsMultipartFile file,
			HttpServletResponse response,   
	        HttpServletRequest request,Model model){
		System.out.println("ss");
		if(!file.isEmpty()){
			String path=request.getSession().getServletContext().getRealPath("/img/collection/");
			System.out.println(path);
			String fileName = file.getOriginalFilename();  
		    String fileType = fileName.substring(fileName.lastIndexOf("."));   
		    String newFileName = new Date().getTime() + fileType;  
	        File file2 = new File(path, newFileName); // 新建一个文件
	        
	        try {
				file.getFileItem().write(file2);
			} catch (Exception e) {
				e.printStackTrace();
			}
	        
	        PrintWriter out;  
	        try {  
	            out = response.getWriter();  
	            out.print(request.getContextPath() + "/img/collection/" + newFileName);   
	            out.flush();  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        }  

		}
		return null;
	}
}
