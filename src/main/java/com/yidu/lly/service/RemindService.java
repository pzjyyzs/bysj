package com.yidu.lly.service;

import java.util.List;

import com.yidu.lly.model.*;

public interface RemindService {
	
	public Remind selectMailRemind(int remindid);
	public List<Remind> selectAllMailRemind(int remindid);
	
	public Remind selectTopMailRemind(int remindid,int objectremind);
	public void updateMailRemind(int useruid,int otheruid);
	
}
