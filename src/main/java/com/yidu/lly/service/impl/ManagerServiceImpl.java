package com.yidu.lly.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import com.yidu.lly.mapper.ManagerMapper;
import com.yidu.lly.model.Manager;
import com.yidu.lly.service.ManagerService;


@Service("managerServiceImpl")

public class ManagerServiceImpl implements ManagerService {
	@Autowired
	private ManagerMapper managerDao;

	@Override
	public Manager selectManager(Manager manager) {
		// TODO Auto-generated method stub
		return managerDao.selectManager(manager);
	}

	

}
