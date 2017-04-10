package com.yidu.lly.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
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

import com.yidu.lly.model.Article;
import com.yidu.lly.model.User;
import com.yidu.lly.service.ArticleService;


@Controller
@RequestMapping("/article")
public class ArticleController {

	@Resource(name="articleServiceImpl")
	private ArticleService articleService;

	public ArticleService getArticleService() {
		return articleService;
	}

	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}
	
	//发表文章
	@RequestMapping(value="/addarticle.do", method = RequestMethod.POST)
	public@ResponseBody Map<String,Object> addArticle(HttpServletRequest request,HttpSession session){
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
	
	@RequestMapping(value="/showArticleId.do",method=RequestMethod.GET)
	public String showArticle(@RequestParam("aid") int aid,HttpServletRequest request,HttpSession session){
		
		Article article=this.articleService.showArticleId(aid);
		session.setAttribute("article", article);
		return "article/showArticle";
	}
}
