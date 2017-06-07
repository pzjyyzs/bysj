package com.yidu.lly.mapper;

import java.util.List;

import com.yidu.lly.model.ComReply;
import com.yidu.lly.model.Comment;

public interface CommentMapper {
	public void insertComment(Comment comment);
	
	public List<Comment> showComment(int comarid);
	
	public Integer selectountComent(int comarid);
	
	public void insertComReply(ComReply comreply);
	
	public  List<ComReply> selectReplyComent();
	public void delComment(int comid);
	public void delreply(int comid);
}
