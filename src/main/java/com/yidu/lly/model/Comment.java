package com.yidu.lly.model;

//评论类 设置评论类的属性
//属性有评论id，评论内容，评论时间，评论者id，被评论的文章id
public class Comment {
	private int comid;
	private String comtext;
	private String comtime;
	private int comuserid;
	private int comarid;
	//设置各个属性的get、set方法
	public int getComid() {
		return comid;
	}
	public void setComid(int comid) {
		this.comid = comid;
	}
	public String getComtext() {
		return comtext;
	}
	public void setComtext(String comtext) {
		this.comtext = comtext;
	}
	public String getComtime() {
		return comtime;
	}
	public void setComtime(String comtime) {
		this.comtime = comtime;
	}
	public int getComuserid() {
		return comuserid;
	}
	public void setComuserid(int comuserid) {
		this.comuserid = comuserid;
	}
	public int getComarid() {
		return comarid;
	}
	public void setComarid(int comarid) {
		this.comarid = comarid;
	}
	

}
