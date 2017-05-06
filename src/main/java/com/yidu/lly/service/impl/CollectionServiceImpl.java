package com.yidu.lly.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.lly.mapper.CollectionMapper;
import com.yidu.lly.model.Colfollow;
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

	@Override
	public void addColfollow(Colfollow colfollow) {
		this.collectionMapper.addColfollow(colfollow);
		
	}

	@Override
	public Colfollow checkColfollow(int uid, int cid) {
		return this.collectionMapper.checkColfollow(uid, cid);
	}

	@Override
	public void delColfollow(Colfollow colf) {
		this.collectionMapper.delColfollow(colf);
		
	}

	@Override
	public List<Collection> showUserCollection(int uid) {
		// TODO Auto-generated method stub
		return this.collectionMapper.showUserCollection(uid);
	}


}
