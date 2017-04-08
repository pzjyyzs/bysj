package com.yidu.lly.service.impl;

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

}
