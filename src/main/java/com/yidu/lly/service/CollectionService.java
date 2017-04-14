package com.yidu.lly.service;

import com.yidu.lly.model.Collection;

public interface CollectionService {

	public void addCollection(Collection collection);
	
	public Collection showCollection(int cid);
	
	public void updateCollection(Collection collection);
}
