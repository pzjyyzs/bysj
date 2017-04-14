package com.yidu.lly.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

import com.mysql.fabric.xmlrpc.base.Array;
import com.yidu.lly.model.Article;
import com.yidu.lly.model.Collection;
import com.yidu.lly.model.User;
import com.yidu.lly.service.impl.ArticleServiceImpl;
import com.yidu.lly.service.impl.ColarticServiceImpl;
import com.yidu.lly.service.impl.CollectionServiceImpl;
import com.yidu.lly.service.impl.UserServiceImpl;

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
	
	@Resource(name="colarticServiceImpl")
	private ColarticServiceImpl colarticServiceImpl;
	
	public ColarticServiceImpl getColarticServiceImpl() {
		return colarticServiceImpl;
	}

	public void setColarticServiceImpl(ColarticServiceImpl colarticServiceImpl) {
		this.colarticServiceImpl = colarticServiceImpl;
	}

	@Resource(name="articleServiceImpl")
	private ArticleServiceImpl articleServiceImpl;
	
	public ArticleServiceImpl getArticleServiceImpl() {
		return articleServiceImpl;
	}

	public void setArticleServiceImpl(ArticleServiceImpl articleServiceImpl) {
		this.articleServiceImpl = articleServiceImpl;
	}

	@Resource(name="userServiceImpl")
	private UserServiceImpl userServiceImpl;
	
	public UserServiceImpl getUserServiceImpl() {
		return userServiceImpl;
	}

	public void setUserServiceImpl(UserServiceImpl userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
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
		this.collectionServiceImpl.addCollection(collection);
		return "redirect:showcollection.do?cid="+cid;
	}
	
	@RequestMapping(value="showcollection.do",method=RequestMethod.GET)
	public String showCollection(HttpServletRequest request,HttpSession session,int cid){
		
		Collection collection=this.collectionServiceImpl.showCollection(cid);
		List<Integer> colarticAidList=this.colarticServiceImpl.showColarticAid(cid);
		User user=this.userServiceImpl.selectUser(collection.getUid());
		if(colarticAidList.size()==0){
			session.setAttribute("flagcolartc", false);
			session.setAttribute("collection", collection);
			session.setAttribute("colArticAidSize", colarticAidList.size());
			session.setAttribute("collectionUser", user);
		}else{
			List<Article> colArticle=new ArrayList<Article>();
			List<User> colArticleUser=new ArrayList<User>();
			for(int i=0;i<colarticAidList.size();i++){
				Article article=this.articleServiceImpl.showArticleId(colarticAidList.get(i));
				colArticle.add(article);
				User u=this.userServiceImpl.selectUser(article.getUid());
				colArticleUser.add(u);
			}
			session.setAttribute("flagcolartc", true);
			session.setAttribute("collection", collection);
			session.setAttribute("colArticAidSize", colarticAidList.size());
			session.setAttribute("collectionUser", user);
			session.setAttribute("colArticle", colArticle);
			session.setAttribute("colArticleUser", colArticleUser);
		}
		return "collection/collection";
	}
	
	@RequestMapping(value="/updatecollection.do",method=RequestMethod.POST)
	public String updateCollection(HttpServletRequest request,HttpSession session){
		String collectionName=request.getParameter("nick-name");
		String collectionIntroduce=request.getParameter("nick-content");
		String collectionimg=request.getParameter("nick-img");
		Collection collection=new Collection();
		
		Collection c=(Collection) session.getAttribute("collection");
		collection.setCid(c.getCid());
		collection.setCollectionname(collectionName);
		collection.setCollectionintroduce(collectionIntroduce);
		collection.setCollectionimg(collectionimg);
		collection.setUid(c.getUid());
		this.collectionServiceImpl.updateCollection(collection);
		session.setAttribute("collection", collection);
		return "redirect:showcollection.do?cid="+c.getCid();
	}
	
	@RequestMapping(value="/collectionImage.do",method=RequestMethod.POST)
	public String  editTbReportImage(@RequestParam("reportFile") CommonsMultipartFile file,
			HttpServletResponse response,   
	        HttpServletRequest request,Model model){
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
