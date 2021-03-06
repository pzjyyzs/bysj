package com.yidu.lly.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;



import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yidu.lly.model.Article;
import com.yidu.lly.model.DyMail;
import com.yidu.lly.model.Friend;
import com.yidu.lly.model.Mail;
import com.yidu.lly.model.Remind;
import com.yidu.lly.model.SaveArticle;
import com.yidu.lly.model.User;
import com.yidu.lly.service.ArticleService;
import com.yidu.lly.service.FriendService;
import com.yidu.lly.service.MailService;
import com.yidu.lly.service.RemindService;
import com.yidu.lly.service.UserService;

@Controller("jsonController")
@RequestMapping("/json")
public class JsonController {
	
	@Resource(name="articleServiceImpl")
	private ArticleService articleService;

	public ArticleService getArticleService() {
		return articleService;
	}

	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}
	@Resource(name = "remindServiceImpl")
	private RemindService remindService;

	public RemindService getRemindService() {
		return remindService;
	}

	public void setRemindService(RemindService remindService) {
		this.remindService = remindService;
	}

	@Resource(name = "userServiceImpl")
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Resource(name = "MailServiceImpl")
	private MailService MailService;

	public MailService getMailService() {
		return MailService;
	}

	// 私信消息动态刷新
	@RequestMapping(value = "/flushSession.do", method = RequestMethod.GET)
	public @ResponseBody
	List<DyMail> showSession(HttpServletRequest request, HttpSession session) {

		User MyUser = (User) session.getAttribute("user");

		String userid = request.getParameter("userid");
		int OtherUserid = Integer.parseInt(userid.trim());

		User OtherUser = this.userService.selectUser(OtherUserid);

		List<Mail> OurSession = this.MailService.selecteMail(MyUser, OtherUser);

		List<DyMail> OurDyMail = new ArrayList<DyMail>();

		for (Mail mail : OurSession) {
			DyMail dymail = new DyMail();

			dymail.setCreattime(mail.getCreattime());
			dymail.setMid(mail.getMid());
			dymail.setReceiveid(mail.getReceiveid());
			dymail.setCotent(mail.getCotent());
			dymail.setSendid(mail.getSendid());
			dymail.setState(mail.getState());

			dymail.setUserid(MyUser.getUid());
			dymail.setUsername(MyUser.getUsername());
			dymail.setUserImg(MyUser.getImg());

			dymail.setOtherUserid(OtherUser.getUid());
			dymail.setOtherUsername(OtherUser.getUsername());
			dymail.setOtherUserImg(OtherUser.getImg());

			OurDyMail.add(dymail);
			/* System.out.println(dymail.getUsername()); */
		}
		session.setAttribute("OtherUser", OtherUser);
		return OurDyMail;
	}

	// 私信消息提醒机制
	@RequestMapping(value = "/FlushRemind.do", method = RequestMethod.GET)
	public @ResponseBody
	List<Remind> FlushRemind(HttpServletRequest request, HttpSession session) {

		String remindid = request.getParameter("remindid");
		Integer RemindId = Integer.parseInt(remindid.trim());

		List<Remind> allremind = this.remindService
				.selectAllMailRemind(RemindId);
		// 所有发消息的用户集合
		Set<Integer> set = new HashSet<Integer>();

		for (Remind remind : allremind) {
			set.add(remind.getMyid());
		}
		// 每一组最高提醒记录
		List<Remind> EveTopremind = new ArrayList<Remind>();
		Iterator<Integer> it = set.iterator();
		while (it.hasNext()) {
			Remind topremind = this.remindService.selectTopMailRemind(RemindId,
					it.next());
			EveTopremind.add(topremind);
		}

		/*
		 * for(Remind remind:EveTopremind){ System.out.println(remind.getId());
		 * }
		 */
		// 1,0分别对应true和false,true表示已阅读，false表示没有阅读；

		return EveTopremind;
	}

	// 读过私信后对数据库的刷新
	@RequestMapping(value = "/readmail.do", method = RequestMethod.GET)
	public @ResponseBody
	void readmail(HttpServletRequest request, HttpSession session) {

		if (null == request.getParameter("myuseruid")
				|| null == request.getParameter("otheruseruid")) {

		} else {
			String useruid = request.getParameter("myuseruid");
			String otheruid = request.getParameter("otheruseruid");

			Integer UserUid = Integer.parseInt(useruid.trim());
			Integer OtherUid = Integer.parseInt(otheruid.trim());

			this.remindService.updateMailRemind(UserUid, OtherUid);
		}
	}

	// 关注提醒机制
	@RequestMapping(value = "/GuanZhuRemind.do", method = RequestMethod.GET)
	public @ResponseBody
	List<Remind> GuanZhuRemind(HttpServletRequest request, HttpSession session) {

		String remindid = request.getParameter("remindid");
		Integer RemindId = Integer.parseInt(remindid.trim());
		// 1,0分别对应true和false,true表示已阅读，false表示没有阅读；

		List<Remind> guanzhuremindList = this.remindService
				.selectGuanZhuRemind(RemindId);

		return guanzhuremindList;
	}

	// 读过关注后对数据库的刷新
	@RequestMapping(value = "/readGuanzhu.do", method = RequestMethod.GET)
	public @ResponseBody
	void readGuanzhu(HttpServletRequest request, HttpSession session) {
		if (null == request.getParameter("myguanzhuId")
				|| null == request.getParameter("otherguanzhuId")) {

		} else {
			String myguanzhuid = request.getParameter("myguanzhuId");
			String otherguanzhuid = request.getParameter("otherguanzhuId");

			Integer myguanzhuId = Integer.parseInt(myguanzhuid.trim());
			Integer otherguanzhuId = Integer.parseInt(otherguanzhuid.trim());

			this.remindService.updateGuanzhuRemind(myguanzhuId, otherguanzhuId);
		}

	}
	
	// 喜欢提醒机制
		@RequestMapping(value = "/LikeRemind.do", method = RequestMethod.GET)
		public @ResponseBody
		List<Remind> LikeRemind(HttpServletRequest request, HttpSession session) {

			String remindid = request.getParameter("remindid");
			Integer RemindId = Integer.parseInt(remindid.trim());
			// 1,0分别对应true和false,true表示已阅读，false表示没有阅读；
			
			List<Article> myArticleList=this.articleService.selectArticle(RemindId);

			List<Remind> LikeList = this.remindService.selectLikeRemind();
			
			List<Remind>  MyLikeList=new ArrayList<Remind>();
			for(Article article:myArticleList){
				for(Remind remind:LikeList){
					if(article.getAid()==remind.getMyid()){
						MyLikeList.add(remind);
					}
				}
			}
			
			return MyLikeList;
		}
	
		
		// 读过喜欢后对数据库的刷新
		@RequestMapping(value = "/readXiHuan.do", method = RequestMethod.GET)
		public @ResponseBody
		void readXiHuan(HttpServletRequest request, HttpSession session) {
			if (null == request.getParameter("myguanzhuId")
					|| null == request.getParameter("otherguanzhuId")) {

			} else {
				String myguanzhuid = request.getParameter("myguanzhuId");
				String otherguanzhuid = request.getParameter("otherguanzhuId");

				Integer myguanzhuId = Integer.parseInt(myguanzhuid.trim());
				Integer otherguanzhuId = Integer.parseInt(otherguanzhuid.trim());

				this.remindService.updateGuanzhuRemind(myguanzhuId, otherguanzhuId);
			}

		}
		
		// 评论提醒机制
		@RequestMapping(value = "/CommentRemind.do", method = RequestMethod.GET)
		public @ResponseBody
		List<Remind> CommentRemind(HttpServletRequest request, HttpSession session) {

			String remindid = request.getParameter("remindid");
			Integer RemindId = Integer.parseInt(remindid.trim());
			// 1,0分别对应true和false,true表示已阅读，false表示没有阅读；

			List<Article> myArticleList=this.articleService.selectArticle(RemindId);

			List<Remind> ComList = this.remindService.selectComRemind();
			
			List<Remind>  MyComList=new ArrayList<Remind>();
			for(Article article:myArticleList){
				for(Remind remind:ComList){
					if(article.getAid()==remind.getMyid()){
						MyComList.add(remind);
					}
				}
			}
			return ComList;
		}
		// 保存文章
		@RequestMapping(value = "/savearticle.do", method = RequestMethod.GET)
		public @ResponseBody
		int savearticle(HttpServletRequest request, HttpSession session) {
			User user=(User)session.getAttribute("user");
			int uid=user.getUid();
			SaveArticle SA=new SaveArticle();
			SA.setType(0);
			SA.setUid(uid);
			this.articleService.saveArticle(SA);
			int SaveAticleId=SA.getId();
		
			
			return SaveAticleId;
		}
		// 显示保存文章的内容
				@RequestMapping(value = "/showsavearticle.do", method = RequestMethod.GET)
				public @ResponseBody
				SaveArticle showsavearticle(HttpServletRequest request, HttpSession session) {
					String id = request.getParameter("id");
					int SAId = Integer.parseInt(id.trim());
				
					SaveArticle SA=this.articleService.selectsaveArticle(SAId);
					return SA;
				}
		// 更新保存文章的内容
				@RequestMapping(value = "/updatesavearticle.do", method = RequestMethod.POST)
				public @ResponseBody
				SaveArticle updatesavearticle(HttpServletRequest request, HttpSession session) {
					String id = request.getParameter("id");
					int SAId = Integer.parseInt(id.trim());
					
					String notetitle=request.getParameter("note_title");
					String notecontent=request.getParameter("note_content");
					
					SaveArticle SA=new SaveArticle();
					SA.setId(SAId);
					SA.setArticlename(notetitle);
					SA.setArticlecontent(notecontent);
					
					

					this.articleService.updateSaveAticle(SA);
					return SA;
					
				}
				
				
				
				// 删除新建文章
				@RequestMapping(value = "/DeletesaveArticle.do", method = RequestMethod.GET)
				public @ResponseBody
				int DeletesaveArticle(HttpServletRequest request, HttpSession session) {
					String id = request.getParameter("id");
					int SAId = Integer.parseInt(id.trim());
					
					this.articleService.deletesaveArticle(SAId);
					
					return SAId;
				}
}