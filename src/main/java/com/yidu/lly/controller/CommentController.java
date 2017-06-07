package com.yidu.lly.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.lly.model.*;
import com.yidu.lly.service.CommentService;

@Controller
@RequestMapping("/comment")
public class CommentController {
	
	@Resource(name="commentServiceImpl")
	private CommentService commentService;

	public CommentService getCommentService() {
		return commentService;
	}

	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}
	//添加评论
	@RequestMapping(value="/addcomment.do",method = RequestMethod.POST)
	public @ResponseBody Map<String,Object> addcomment(HttpServletRequest request,HttpSession session){
		Map<String,Object> map = new HashMap<String,Object>();
		Article article =(Article) session.getAttribute("article");
		Comment c = new Comment();
		c.setComarid(article.getAid());
		User user=(User) session.getAttribute("user");
		c.setComuserid(user.getUid());
		String comtext=  request.getParameter("comtext");
		c.setComtext(comtext);
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String comtime=sdf.format(date);
		
		c.setComtime(comtime);
		this.commentService.insertComment(c);
		
		return map;
	}
	
	@RequestMapping(value="/delcomment.do",method = RequestMethod.POST)
	public @ResponseBody Map<String,Object> delcomment(HttpServletRequest request,HttpSession session){
		Map<String,Object> map = new HashMap<String,Object>();
		String comids=request.getParameter("comid");
		int comid=Integer.parseInt(comids);
		this.commentService.delComment(comid);
		this.commentService.delreply(comid);
		return map;
	}
	
	//回复评论

	@RequestMapping(value="/replycomment.do",method = RequestMethod.POST)
	public  String replycomment(HttpServletRequest request,HttpSession session){
		String articleid=request.getParameter("articleid");
		String replycotent=request.getParameter("replycomment");
		String Comid=request.getParameter("commentcomid");
		String Replyuid=request.getParameter("useruid");
		
		Integer comid=Integer.parseInt(Comid);
		Integer replyuid=Integer.parseInt(Replyuid);
		
		ComReply comreply=new ComReply();
		comreply.setComid(comid);
		comreply.setReplyuid(replyuid);
		comreply.setReplycotent(replycotent);
		
		this.commentService.insertComReply(comreply);
		
		  return "redirect:/article/showArticleId.do?aid="+articleid+"";
		
	}
	
	

}
