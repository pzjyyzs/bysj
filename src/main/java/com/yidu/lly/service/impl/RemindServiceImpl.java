package com.yidu.lly.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.lly.mapper.*;
import com.yidu.lly.model.*;
import com.yidu.lly.service.RemindService;

@Service("remindServiceImpl")
public class RemindServiceImpl implements RemindService {
	
	@Autowired
	private RemindMapper RemindMapper;

	@Override
	public Remind selectRMailemind(int remindid) {
		// TODO Auto-generated method stub
		return this.RemindMapper.selectRMailemind(remindid);
	}
	

}
