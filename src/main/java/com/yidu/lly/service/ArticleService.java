package com.yidu.lly.service;

import java.util.List;

import com.yidu.lly.model.Article;

public interface ArticleService {
	public void insertArticle(Article article);
	
	public List<Article> showArticle();
	
	public Article showArticleId(int aid);
}
