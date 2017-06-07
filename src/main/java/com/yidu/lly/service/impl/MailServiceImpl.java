package com.yidu.lly.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.lly.mapper.MailMapper;
import com.yidu.lly.model.Mail;
import com.yidu.lly.model.User;
import com.yidu.lly.service.MailService;

@Service("MailServiceImpl")
public class MailServiceImpl implements MailService{

	@Autowired
	private MailMapper MailMapper;

	public List<Mail> selectReceiveMail(User user) {
		// TODO Auto-generated method stub
		return this.MailMapper.selectReceiveMail(user);
	}
	
	public List<Mail> selectSendMail(User user) {
		// TODO Auto-generated method stub
		return this.MailMapper.selectSendMail(user);
	}

	public List<Mail> selecteMail(User MyUser, User OtherUser) {
		// TODO Auto-generated method stub
		
		
		
		HashMap<String,Object> params = new HashMap<String,Object>();
		params.put("MyUserid", MyUser.getUid());
		params.put("OtherUserid", OtherUser.getUid());
	
		return this.MailMapper.selecteMail(params);
	}

	public void delMail(Mail mail) {
		// TODO Auto-generated method stub
		this.MailMapper.delMail(mail);
		
	}

	public void insertMail(Mail mail) {
		// TODO Auto-generated method stub
		this.MailMapper.insertMail(mail);
	}
	

}
