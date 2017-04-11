package com.yidu.lly.mapper;

import java.util.List;
import java.util.Map;

import com.yidu.lly.model.Article;
import com.yidu.lly.model.Mail;
import com.yidu.lly.model.User;

public interface MailMapper {
	public List<Mail> selectReceiveMail(User user);
	public List<Mail> selectSendMail(User user);
	public List<Mail> selecteMail(Map<String, Object> parms);
	public void delMail(Mail mail);
	public void insertMail(Mail mail);
}
