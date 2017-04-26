package com.yidu.lly.service;



import java.util.List;

import com.yidu.lly.model.*;

public interface CommentService {
	
	public void insertComment(Comment comment);
	
	public List<Comment> showComent(int comarid);
	
	public Integer selectountComent(int comarid);
	
	public void insertComReply(ComReply comreply );
	
	public List<ComReply> selectReplyComent();
}
