package com.yidu.lly.service;

import java.util.List;

import com.yidu.lly.model.Mail;
import com.yidu.lly.model.User;

public interface MailService {
	public List<Mail> selectReceiveMail(User user);
	public List<Mail> selectSendMail(User user);
	public List<Mail> selecteMail(User MyUser,User OtherUser);
	public void delMail(Mail  mail);
	public void insertMail(Mail  mail);
	
	
}
