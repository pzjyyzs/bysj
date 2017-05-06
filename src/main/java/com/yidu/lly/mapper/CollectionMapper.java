package com.yidu.lly.mapper;

import java.util.List;

import com.yidu.lly.model.Colfollow;
import com.yidu.lly.model.Collection;

public interface CollectionMapper {


	public void addCollection(Collection collection);
	
	public Collection showCollection(int cid);
	
	public void updateCollection(Collection collection);
	
	public void addColfollow(Colfollow colfollow);
	
	public Colfollow checkColfollow(int uid,int cid);
	
	public void delColfollow(Colfollow colf);
	
	public List<Collection> showUserCollection(int uid);
}
