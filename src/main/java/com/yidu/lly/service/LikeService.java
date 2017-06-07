package com.yidu.lly.service;

import java.util.ArrayList;





import com.yidu.lly.model.Like;


public interface LikeService {

	 
	 public void insertLike(Like like);
	 public Like selectLike(Like like);
	 public Integer selectountLike(Like like);
	 public void delLike(Like like);
	 public ArrayList<Like> showxihuan(String befortime,String aftertime);

}
