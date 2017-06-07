package com.yidu.lly.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.lly.mapper.CommentMapper;
import com.yidu.lly.model.ComReply;
import com.yidu.lly.model.Comment;
import com.yidu.lly.service.CommentService;
//接口的实现类
@Service("commentServiceImpl")
public class  CommentServiceImpl implements CommentService  {
	
	@Autowired
	private CommentMapper commentMapper;
	//映射Mapper里的方法showComment
	
	public void insertComment(Comment comment){
		this.commentMapper.insertComment(comment);
	}

	public List<Comment> showComent(int comarid) {
		
		return this.commentMapper.showComment(comarid);
	}

	public Integer selectountComent(int comarid) {
		// TODO Auto-generated method stub
		return this.commentMapper.selectountComent(comarid);
	}

	public void insertComReply(ComReply comreply) {
		// TODO Auto-generated method stub
		 this.commentMapper.insertComReply(comreply);
	}

	public  List<ComReply> selectReplyComent() {
		// TODO Auto-generated method stub
		return  this.commentMapper.selectReplyComent();
	}
	public void delComment(int comid){
		this.commentMapper.delComment(comid);
	}
	public void delreply(int comid){
		this.commentMapper.delreply(comid);
	}
}
