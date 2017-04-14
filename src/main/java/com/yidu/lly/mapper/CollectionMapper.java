package com.yidu.lly.mapper;

import com.yidu.lly.model.Collection;

public interface CollectionMapper {

	public void addCollection(Collection collection);
	
	public Collection showCollection(int cid);
	
	public void updateCollection(Collection collection);
}
