package com.yidu.lly.mapper;

import java.util.List;

import com.yidu.lly.model.Article;

public interface ArticleMapper {
	public void insertArticle(Article article);
	
	public List<Article> showArticle();
	
	public Article showArticleId(int aid);
	
	public List<Article> selectArticle(int uid);
}
