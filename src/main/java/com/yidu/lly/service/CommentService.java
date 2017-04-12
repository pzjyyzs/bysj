package com.yidu.lly.service;



import java.util.List;

import com.yidu.lly.model.Comment;

public interface CommentService {
	public void insertComment(Comment comment);
	
	public List<Comment> showComent(int comarid);
	

}
