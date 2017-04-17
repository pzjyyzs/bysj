package com.yidu.lly.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.lly.mapper.ArticleMapper;
import com.yidu.lly.model.Article;
import com.yidu.lly.service.ArticleService;

@Service("articleServiceImpl")
public class ArticleServiceImpl implements ArticleService{

	@Autowired
	private ArticleMapper articleMapper;
	
	public void insertArticle(Article article) {
		this.articleMapper.insertArticle(article);	
	}

	@Override
	public List<Article> showArticle() {
		
		return this.articleMapper.showArticle();
	}

	@Override
	public Article showArticleId(int aid) {
		return this.articleMapper.showArticleId(aid);
	}

	@Override
	public List<Article> selectArticle(int uid) {
		// TODO Auto-generated method stub
		return this.articleMapper.selectArticle(uid);
	}

}
