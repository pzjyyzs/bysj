package com.yidu.lly.service;

import java.util.List;

import com.yidu.lly.model.Colartic;

public interface ColarticService {

	public List<Integer> showColarticAid(int cid);
	
	public List<Integer> showColarticCid(int aid);
	
	public void addColartic(Colartic colartic);
	
	public void delColartic(Colartic colartic);
}
