package com.yidu.lly.model;
//文章类 设置文章类的属性
//属性有文章id，文章名，文章发布时间，文章内容，作者id，文章阅读量，文章首图的地址
public class Article {
	private int aid;
	private String articlename;
	private String articletime;
	private String articlecontent;
	private int uid;
	private int articleread;
	private String aimgaddress;
	//设置各个属性的get、set方法
	public String getAimgaddress() {
		return aimgaddress;
	}
	public void setAimgaddress(String aimgaddress) {
		this.aimgaddress = aimgaddress;
	}
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
