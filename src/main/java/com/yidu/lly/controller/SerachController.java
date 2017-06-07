package com.yidu.lly.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yidu.lly.luence.LuceneDao;
import com.yidu.lly.model.Article;
import com.yidu.lly.service.ArticleService;

@Controller
@RequestMapping("/search")
public class SerachController {

	@Resource(name="articleServiceImpl")
	private ArticleService articleService;

	public ArticleService getArticleService() {
		return articleService;
	}

	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}
	
	private LuceneDao luceneDao=new LuceneDao();
	
	@RequestMapping(value="search.do",method=RequestMethod.GET)
	public String serach(HttpServletRequest request,HttpSession session,String q) throws Exception{
		List<Article> allArticle=this.articleService.selectAllArticle();
		for (Article article : allArticle) {
			luceneDao.addIndex(article);
		}		
		List<Article> searchArticle=luceneDao.findIndex(q, 0, 10);
		for (Article article : searchArticle) {
			System.out.println(article.getArticlename());
		}
		return "search";
	}
}
