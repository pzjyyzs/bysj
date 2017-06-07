package com.yidu.lly.mapper;

import java.util.List;

import com.yidu.lly.model.Article;
import com.yidu.lly.model.SaveArticle;

public interface ArticleMapper {
	public void insertArticle(Article article);
	
	public List<Article> showArticle();
	
	public Article showArticleId(int aid);
	
	public List<Article> selectArticle(int uid);
	
	public void saveArticle(SaveArticle sa);
	
	public SaveArticle selectsaveArticle(int id);
	public void updateSaveAticle(SaveArticle sa);
   
	public void deletesaveArticle(int id);
	
	public List<SaveArticle> selectMysaveArticle(int uid);
	public List<Article> selectAllArticle();
	
	public void delArticle(int aid);
	public void updArticle(Article article);
	public int selArticle(String articlename,String articlecontent,String articletime);
}
