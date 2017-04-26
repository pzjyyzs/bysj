package com.yidu.lly.mapper;

import java.util.List;
import java.util.Map;

import com.yidu.lly.model.Remind;

public interface RemindMapper {
	public Remind selectMailRemind(int remindid);
	
	public List<Remind> selectAllMailRemind(int remindid);
	
	public Remind selectTopMailRemind(Map<String, Object> parms);
	
	public void updateMailRemind(Map<String, Object> parms);
	
	public List<Remind> selectGuanZhuRemind(int remindid);
	
	public void updateGuanzhuRemind(Map<String, Object> parms);
	
	public List<Remind> selectLikeRemind();
	public List<Remind> selectComRemind();
	
}
