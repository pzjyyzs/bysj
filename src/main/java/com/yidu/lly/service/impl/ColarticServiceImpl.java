package com.yidu.lly.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.lly.mapper.ColarticMapper;
import com.yidu.lly.service.ColarticService;

@Service("colarticServiceImpl")
public class ColarticServiceImpl implements ColarticService{

	@Autowired
	private ColarticMapper colarticMapper;
	
	@Override
	public List<Integer> showColarticAid(int cid) {
		return this.colarticMapper.showColarticAid(cid);
	}

}
