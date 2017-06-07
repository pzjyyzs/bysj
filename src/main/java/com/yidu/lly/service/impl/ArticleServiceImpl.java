package com.yidu.lly.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.lly.mapper.ArticleMapper;
import com.yidu.lly.model.Article;
import com.yidu.lly.model.SaveArticle;
import com.yidu.lly.service.ArticleService;

@Service("articleServiceImpl")
public class ArticleServiceImpl implements ArticleService{

	@Autowired
	private ArticleMapper articleMapper;
	
	public void insertArticle(Article article) {
		this.articleMapper.insertArticle(article);	
	}

	public List<Article> showArticle() {
		
		return this.articleMapper.showArticle();
	}

	public Article showArticleId(int aid) {
		return this.articleMapper.showArticleId(aid);
	}

	public List<Article> selectArticle(int uid) {
		// TODO Auto-generated method stub
		return this.articleMapper.selectArticle(uid);
	}

	public void saveArticle(SaveArticle sa) {
		// TODO Auto-generated method stub
		 this.articleMapper.saveArticle(sa);	
	}

	public SaveArticle selectsaveArticle(int id) {
		// TODO Auto-generated method stub
		return this.articleMapper.selectsaveArticle(id);
	}

	public void updateSaveAticle(SaveArticle sa) {
		// TODO Auto-generated method stub
		this.articleMapper.updateSaveAticle(sa);
	}

	public void deletesaveArticle(int id) {
		// TODO Auto-generated method stub
		this.articleMapper.deletesaveArticle(id); 
		
	}

	public List<SaveArticle> selectMysaveArticle(int uid) {
		// TODO Auto-generated method stub
		return this.articleMapper.selectMysaveArticle(uid);
	}

	@Override
	public List<Article> selectAllArticle() {
		// TODO Auto-generated method stub
		return this.articleMapper.selectAllArticle();
	}
	
	public void delArticle(int aid){
		this.articleMapper.delArticle(aid);
	}

	public void updArticle(Article article){
		this.articleMapper.updArticle(article);
	}
	
	public int selArticle(String articlename,String articlecontent,String articletime){
		return this.articleMapper.selArticle(articlename,articlecontent,articletime);
	}
}
