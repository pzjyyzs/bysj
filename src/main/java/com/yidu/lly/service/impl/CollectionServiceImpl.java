package com.yidu.lly.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.lly.mapper.CollectionMapper;
import com.yidu.lly.model.Collection;
import com.yidu.lly.service.CollectionService;

@Service("collectionServiceImpl")
public class CollectionServiceImpl implements CollectionService{

	@Autowired
	private CollectionMapper collectionMapper;
	
	@Override
	public void addCollection(Collection collection) {
		this.collectionMapper.addCollection(collection);	
	}

	@Override
	public Collection showCollection(int cid) {
		return this.collectionMapper.showCollection(cid);
	}

	@Override
	public void updateCollection(Collection collection) {
		this.collectionMapper.updateCollection(collection);
		
	}

}
