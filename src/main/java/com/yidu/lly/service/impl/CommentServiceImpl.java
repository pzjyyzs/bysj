package com.yidu.lly.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.lly.mapper.CommentMapper;
import com.yidu.lly.model.Comment;
import com.yidu.lly.service.CommentService;

@Service("commentServiceImpl")
public class  CommentServiceImpl implements CommentService  {
	
	@Autowired
	private CommentMapper commentMapper;
	
	public void insertComment(Comment comment){
		this.commentMapper.insertComment(comment);
	};
}
