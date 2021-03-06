package com.yidu.lly.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.yidu.lly.model.*;
import com.yidu.lly.service.ArticleService;
import com.yidu.lly.service.ColarticService;
import com.yidu.lly.service.CollectionService;
import com.yidu.lly.service.CommentService;
import com.yidu.lly.service.LikeService;
import com.yidu.lly.service.UserService;


@Controller
@RequestMapping("/article")
public class ArticleController {
	@Resource(name="commentServiceImpl")
	private CommentService commentService;
	
	public CommentService getCommentService() {
		return commentService;
	}

	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}

	@Resource(name="articleServiceImpl")
	private ArticleService articleService;

	public ArticleService getArticleService() {
		return articleService;
	}

	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}
	
	@Resource(name="userServiceImpl")
	private UserService userService;
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	
	
	@Resource(name="likeServiceImpl")
	private LikeService likeService;
	

	public LikeService getLikeService() {
		return likeService;
	}

	public void setLikeService(LikeService likeService) {
		this.likeService = likeService;
	}
	
	@Resource(name="collectionServiceImpl")
	private CollectionService collectionService;
	
	public CollectionService getCollectionService() {
		return collectionService;
	}

	public void setCollectionService(CollectionService collectionService) {
		this.collectionService = collectionService;
	}

	@Resource(name="colarticServiceImpl")
	private ColarticService colarticService;
	
	public ColarticService getColarticService() {
		return colarticService;
	}

	public void setColarticService(ColarticService colarticService) {
		this.colarticService = colarticService;
	}

	//发表文章
	@RequestMapping(value="/addarticle.do", method = RequestMethod.POST)
	public @ResponseBody Map<String,Object> addArticle(HttpServletRequest request,HttpSession session){
		Map<String,Object> map = new HashMap<String,Object>();
		String articlename=request.getParameter("note_title");
		String articlecontent=request.getParameter("note_content");
		String aimgaddress=request.getParameter("aimgaddress");
		System.out.println(aimgaddress);
		User user=(User) session.getAttribute("user");
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String articletime=sdf.format(date);
		
		Article article=new Article();
		article.setArticlename(articlename);
		article.setArticlecontent(articlecontent);
		article.setArticletime(articletime);
		article.setUid(user.getUid());
		article.setArticleread(0);
		article.setAimgaddress(aimgaddress);
		
		this.articleService.insertArticle(article);
		int aid=this.articleService.selArticle(articlename,articlecontent,articletime);
		map.put("aid", aid);
		map.put("articlename", articlename);
		return map;
	}
	
	//上传图片
	@RequestMapping(value="/editImage.do",method=RequestMethod.POST)
	public String  editTbReportImage(@RequestParam("reportFile") CommonsMultipartFile file,
			HttpServletResponse response,   
	        HttpServletRequest request,Model model){
		if(!file.isEmpty()){
			String path=request.getSession().getServletContext().getRealPath("/img/article/");
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
	            out.print(request.getContextPath() + "/img/article/" + newFileName);   
	            out.flush();  
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        }  

		}
		return null;
	}
	//显示文章
	@RequestMapping(value="/showArticleId.do",method=RequestMethod.GET)
	public String showArticle(@RequestParam("aid") int aid,HttpServletRequest request,HttpSession session){
		
		Article article=this.articleService.showArticleId(aid);
		List<Comment> comlist=this.commentService.showComent(aid);
		List<User> usercomlist=new ArrayList<User>();
		User auser=this.userService.selectUser(article.getUid());
		
		User user=(User)session.getAttribute("user");
		
		Like like=new Like();
		like.setUserid(user.getUid());
		like.setArticleid(aid);
		
		String str1="display:none";
		String str2="";
		
		if (null==this.likeService.selectLike(like)) {
			str1="";
			str2="display:none";
		}
		
		Integer likecount=this.likeService.selectountLike(like);
		Integer comcount=commentService.selectountComent(aid);
	
		
		for(int i=0;i<comlist.size();i++){
			User comuser=this.userService.selectUser(comlist.get(i).getComuserid());
			usercomlist.add(comuser);
		}
		
		session.setAttribute("article", article);
		session.setAttribute("auser", auser);
		session.setAttribute("comlist", comlist);
		session.setAttribute("usercomlist", usercomlist);
		session.setAttribute("comcount", comcount);
		

		session.setAttribute("likecount", likecount);
		session.setAttribute("str2", str2);
		session.setAttribute("str1", str1);
		
		
		
		//所有回复评论集合
		
	
		
		List<ComReply> comreplylist= this.commentService.selectReplyComent();
		for(ComReply item:comreplylist){
			item.setReplyuname((this.userService.selectUser(item.getReplyuid())).getUsername());
		}

		session.setAttribute("comreplylist", comreplylist);
		
		//收藏
		
		List<Integer> showCollection = this.colarticService.showColarticCid(aid);
		List<Collection> articleCollection=new ArrayList<Collection>();
		for (Integer i : showCollection) {
			Collection c=this.collectionService.showCollection(i);
			articleCollection.add(c);
		}
		List<Collection> userCollection=this.collectionService.showUserCollection(user.getUid());
		session.setAttribute("articleCollection", articleCollection);
		session.setAttribute("userCollection", userCollection);
		return "article/wenzhang";
	}
	
	@RequestMapping(value="/showWrite.do",method=RequestMethod.GET)
	public String showWrite(HttpServletRequest request,HttpSession session){
		User user=(User)session.getAttribute("user");
		int uid=user.getUid();
		
		List<SaveArticle> SaveArticlelist=this.articleService.selectMysaveArticle(uid);
		String str="";
		if(SaveArticlelist.isEmpty() ){
			str="display:none";
		}else{
			str="display:block";
		}
		session.setAttribute("SaveArticlelist", SaveArticlelist);
		session.setAttribute("str", str);
		return "article/write";
	}
	
	@RequestMapping(value="/updateArticle.do",method=RequestMethod.GET)
	public String updateArticle(HttpServletRequest request,HttpSession session){
		
		Article a = (Article) session.getAttribute("article");
		int aid=a.getAid();
		
		int iaid=Integer.valueOf(aid);
		Article article=this.articleService.showArticleId(iaid);
		session.setAttribute("updataArticle", article);
				
		return "article/updatewrite";
	}
	
	@RequestMapping(value="/delArticle.do", method = RequestMethod.POST)
	public @ResponseBody Map<String,Object> delArticle(HttpServletRequest request,HttpSession session){
		Map<String,Object> map = new HashMap<String,Object>();
		String said=request.getParameter("aid");
		int aid=Integer.valueOf(said);
		this.articleService.delArticle(aid);
		return map;
	}
	@RequestMapping(value="/updArticle.do", method = RequestMethod.POST)
	public  @ResponseBody Map<String,Object> updArticle(HttpServletRequest request,HttpSession session){
		Map<String,Object> map = new HashMap<String,Object>();
		String said=request.getParameter("aid");
		int aid=Integer.valueOf(said);
		String articlename=request.getParameter("articlename");
		String articlecontent=request.getParameter("articlecontent");
		String aimgaddress=request.getParameter("aimgaddress");
		System.out.println(articlecontent);
		Article article=new Article();
		article.setAid(aid);
		article.setArticlename(articlename);
		article.setArticlecontent(articlecontent);
		article.setAimgaddress(aimgaddress);
		
		this.articleService.updArticle(article);
		
		return map;
	}
}
