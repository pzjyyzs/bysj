package com.yidu.lly.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.yidu.lly.model.Article;
import com.yidu.lly.model.Colartic;
import com.yidu.lly.model.Colfollow;
import com.yidu.lly.model.Collection;
import com.yidu.lly.model.Coltag;
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

	public void setUserSserviceImpl(UserServiceImpl userServiceImpl) {
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
	
	@RequestMapping(value="/updatecollection.do",method = RequestMethod.POST)
	public String updateCollection(HttpServletRequest request,HttpSession session){
		User user=(User) session.getAttribute("user");
		String collectionName=request.getParameter("nick-name");
		String collectionIntroduce=request.getParameter("nick-content");
		String collectionimg=request.getParameter("nick-img");
		Collection col=(Collection) session.getAttribute("collection");
		int cid=col.getCid();
		Collection collection=new Collection();
		collection.setCid(cid);
		collection.setCollectionimg(collectionimg);
		collection.setCollectionintroduce(collectionIntroduce);
		collection.setCollectionname(collectionName);
		collection.setUid(user.getUid());
		this.collectionServiceImpl.updateCollection(collection);
		return "redirect:showcollection.do?cid="+cid;
	}
	
	@RequestMapping(value="showcollection.do",method=RequestMethod.GET)
	public String showCollection(HttpServletRequest request,HttpSession session,int cid){
		User user=(User) session.getAttribute("user");
		Collection collection=this.collectionServiceImpl.showCollection(cid);
		List<Integer> showColarticAid=this.colarticServiceImpl.showColarticAid(cid);
		List<Coltag> coltagList=this.collectionServiceImpl.showtag(cid);
		int coltagLen=coltagList.size();
		List<Article> colArticle=new ArrayList<Article>();
		List<User> colArticleUser=new ArrayList<User>();
		if(showColarticAid.size()==0){
			session.setAttribute("flagcolartc", false);
		}else{
			for(int i=0;i<showColarticAid.size();i++){
				Article a=this.articleServiceImpl.showArticleId(showColarticAid.get(i));
				colArticle.add(a);
			}
			for(int i=0;i<colArticle.size();i++){
				User u=this.userServiceImpl.selectUser(colArticle.get(i).getUid());
				colArticleUser.add(u);
			}
				session.setAttribute("flagcolartc", true);
		}
		
		User collectionUser=this.userServiceImpl.selectUser(collection.getUid());
		if(this.collectionServiceImpl.checkColfollow(user.getUid(), cid)==null){
			session.setAttribute("colfollowflag", false);
		}else{
			session.setAttribute("colfollowflag", true);
		}
		session.setAttribute("collectionUser", collectionUser);

		session.setAttribute("collection", collection);
		session.setAttribute("colArticAidSize", showColarticAid.size());
		session.setAttribute("colArticle", colArticle);
		session.setAttribute("colArticleUser", colArticleUser);
		session.setAttribute("coltagList", coltagList);
		session.setAttribute("coltagLen", coltagLen);
		return "collection/collection";
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
	
	@RequestMapping(value="/collect.do",method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> collect(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		String colfo=request.getParameter("colfo");
		Map<String,Object> map = new HashMap<String,Object>();
		User u=(User) session.getAttribute("user");
		Collection c=(Collection) session.getAttribute("collection");
		Colfollow colf=new Colfollow();
		colf.setCid(c.getCid());
		colf.setUid(u.getUid());
		if(colfo.equals("0")){
			this.collectionServiceImpl.addColfollow(colf);
			map.put("result", "0");
		}else{
			this.collectionServiceImpl.delColfollow(colf);
			map.put("result", "1");
		}
		return map;
	}
	
	@RequestMapping(value="/colladdartic.do",method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> collectionAddArticle(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		Map<String,Object> map = new HashMap<String,Object>();
		int aid=Integer.valueOf(request.getParameter("aid"));
		int cid=Integer.valueOf(request.getParameter("cid"));
		
		Colartic colartic=new Colartic();
		colartic.setAid(aid);
		colartic.setCid(cid);
		this.colarticServiceImpl.addColartic(colartic);
		return map;
	}
	@RequestMapping(value="/colldelartic.do",method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> collectionDelArticle(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		Map<String,Object> map = new HashMap<String,Object>();
		int aid=Integer.valueOf(request.getParameter("aid"));
		int cid=Integer.valueOf(request.getParameter("cid"));
		Colartic colartic=new Colartic();
		colartic.setAid(aid);
		colartic.setCid(cid);
		this.colarticServiceImpl.delColartic(colartic);
		return map;
	}
	
	public String allCollectionForUser(HttpServletRequest request,HttpSession session){
		User user=(User) session.getAttribute("user");
		ArrayList<Collection> uidCollection=(ArrayList<Collection>) this.collectionServiceImpl.showUserCollection(user.getUid());
		session.setAttribute("uidCollection", uidCollection);
		return "message/Contribute";
	}
	
	@RequestMapping(value="/addcoltag.do",method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> addcoltag(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		Map<String,Object> map = new HashMap<String,Object>();
		String tagname=request.getParameter("tagname");
		User u=(User) session.getAttribute("user");
		Collection c=(Collection) session.getAttribute("collection");
		
		Coltag coltag=new Coltag();
		coltag.setCid(c.getCid());
		coltag.setTagname(tagname);
		coltag.setTaguid(u.getUid());
		this.collectionServiceImpl.addColtag(coltag);
		return map;
	}
	
	@RequestMapping(value="/delcoltag.do",method=RequestMethod.GET)
	public @ResponseBody Map<String,Object> delcoltag(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		Map<String,Object> map = new HashMap<String,Object>();
		String scoltid=request.getParameter("coltid");
		int coltid=Integer.valueOf(scoltid);
		this.collectionServiceImpl.deltag(coltid);
		return map;
	}
}
