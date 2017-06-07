package com.yidu.lly.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.lly.mapper.ColarticMapper;
import com.yidu.lly.model.Colartic;
import com.yidu.lly.service.ColarticService;

@Service("colarticServiceImpl")
public class ColarticServiceImpl implements ColarticService{

	@Autowired
	private ColarticMapper colarticMapper;
	
	public List<Integer> showColarticAid(int cid) {
		return this.colarticMapper.showColarticAid(cid);
	}
	
	public List<Integer> showColarticCid(int aid) {
		// TODO Auto-generated method stub
		return this.colarticMapper.showColarticCid(aid);
	}

	public void addColartic(Colartic colartic) {
		this.colarticMapper.addColartic(colartic);
	}

	public void delColartic(Colartic colartic) {
		this.colarticMapper.delColartic(colartic);	
	}

}
