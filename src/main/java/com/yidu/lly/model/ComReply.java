package com.yidu.lly.model;

//评论类 设置评论类的属性
//属性有评论id，评论内容，评论时间，评论者id，被评论的文章id
public class ComReply {
	private int id;
	private int comid;
	private int replyuid;
	private String replytime;
	private String replycotent;
	private String replyuname;
	
	
	public String getReplyuname() {
		return replyuname;
	}
	public void setReplyuname(String replyuname) {
		this.replyuname = replyuname;
	}
	//设置各个属性的get、set方法
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getComid() {
		return comid;
	}
	public void setComid(int comid) {
		this.comid = comid;
	}
	public int getReplyuid() {
		return replyuid;
	}
	public void setReplyuid(int replyuid) {
		this.replyuid = replyuid;
	}
	public String getReplytime() {
		return replytime;
	}
	public void setReplytime(String replytime) {
		this.replytime = replytime;
	}
	public String getReplycotent() {
		return replycotent;
	}
	public void setReplycotent(String replycotent) {
		this.replycotent = replycotent;
	}

	

}
