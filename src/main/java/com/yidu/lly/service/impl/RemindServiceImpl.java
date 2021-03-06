package com.yidu.lly.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.lly.mapper.*;
import com.yidu.lly.model.*;
import com.yidu.lly.service.RemindService;

@Service("remindServiceImpl")
public class RemindServiceImpl implements RemindService {
	
	@Autowired
	private RemindMapper RemindMapper;

	public Remind selectMailRemind(int remindid) {
		// TODO Auto-generated method stub
		return this.RemindMapper.selectMailRemind(remindid);
	}

	public List<Remind> selectAllMailRemind(int remindid) {
		// TODO Auto-generated method stub
		return this.RemindMapper.selectAllMailRemind(remindid);
	}

	public Remind selectTopMailRemind(int remindid, int objectremind) {
		
		HashMap<String,Object> params = new HashMap<String,Object>();
		
		params.put("remindid", remindid);
		
		params.put("objectremind", objectremind);
		// TODO Auto-generated method stub
		return this.RemindMapper.selectTopMailRemind(params);
	}

	public void updateMailRemind(int useruid, int otheruid) {
		// TODO Auto-generated method stub
		
        HashMap<String,Object> params = new HashMap<String,Object>();
		
		params.put("useruid", useruid);
		params.put("otheruid", otheruid);
		
		this.RemindMapper.updateMailRemind(params);
	}

	public List<Remind> selectGuanZhuRemind(int remindid) {
		// TODO Auto-generated method stub
		
		
		return this.RemindMapper.selectGuanZhuRemind(remindid);
	}

	public void updateGuanzhuRemind(int myguanzhuId, int otherguanzhuId) {
		// TODO Auto-generated method stub
		 HashMap<String,Object> params = new HashMap<String,Object>();
			
			params.put("myguanzhuId", myguanzhuId);
			params.put("otherguanzhuId", otherguanzhuId);
		this.RemindMapper.updateGuanzhuRemind(params);
		
		
	}

	public List<Remind> selectLikeRemind() {
		// TODO Auto-generated method stub
		return RemindMapper.selectLikeRemind();
	}

	public List<Remind> selectComRemind() {
		// TODO Auto-generated method stub
		return RemindMapper.selectComRemind();
	}
	

}
