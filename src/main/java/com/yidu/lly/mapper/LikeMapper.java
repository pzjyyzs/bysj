package com.yidu.lly.mapper;

import java.util.ArrayList;
import java.util.Map;

import com.yidu.lly.model.Like;

public interface LikeMapper {

	public void insertLike(Like like);
	public Like selectLike(Like like);
	public int selectountLike(Like like);
	public void delLike(Like like);
	public ArrayList<Like> showxihuan(String befortime,String aftertime);
}
