package com.yidu.lly.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yidu.lly.mapper.CollectionMapper;
import com.yidu.lly.model.Colfollow;
import com.yidu.lly.model.Collection;
import com.yidu.lly.model.Coltag;
import com.yidu.lly.service.CollectionService;

@Service("collectionServiceImpl")
public class CollectionServiceImpl implements CollectionService{

	@Autowired
	private CollectionMapper collectionMapper;
	
	public void addCollection(Collection collection) {
		this.collectionMapper.addCollection(collection);	
	}
	public Collection showCollection(int cid) {

		return this.collectionMapper.showCollection(cid);
	}

	public void updateCollection(Collection collection) {
		this.collectionMapper.updateCollection(collection);
		
	}

	public void addColfollow(Colfollow colfollow) {
		this.collectionMapper.addColfollow(colfollow);
		
	}

	public Colfollow checkColfollow(int uid, int cid) {
		return this.collectionMapper.checkColfollow(uid, cid);
	}

	public void delColfollow(Colfollow colf) {
		this.collectionMapper.delColfollow(colf);
		
	}

	public List<Collection> showUserCollection(int uid) {
		// TODO Auto-generated method stub
		return this.collectionMapper.showUserCollection(uid);
	}

	public void addColtag(Coltag coltag){
		this.collectionMapper.addColtag(coltag);
	}

	public List<Coltag> showtag(int cid){
		return this.collectionMapper.showtag(cid);
	}
	
	public void deltag(int coltid){
		this.collectionMapper.deltag(coltid);
	}
}
