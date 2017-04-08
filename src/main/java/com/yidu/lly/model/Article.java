package com.yidu.lly.model;

public class Article {
	private int aid;
	private String articlename;
	private String articletime;
	private String articlecontent;
	private int uid;
	private int articleread;
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getArticlename() {
		return articlename;
	}
	public void setArticlename(String articlename) {
		this.articlename = articlename;
	}
	public String getArticletime() {
		return articletime;
	}
	public void setArticletime(String articletime) {
		this.articletime = articletime;
	}
	public String getArticlecontent() {
		return articlecontent;
	}
	public void setArticlecontent(String articlecontent) {
		this.articlecontent = articlecontent;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getArticleread() {
		return articleread;
	}
	public void setArticleread(int articleread) {
		this.articleread = articleread;
	}
	
}
