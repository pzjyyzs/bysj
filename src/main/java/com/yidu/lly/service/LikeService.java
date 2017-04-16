package com.yidu.lly.service;

import java.util.List;



import com.yidu.lly.model.User;
import com.yidu.lly.model.Like;


public interface LikeService {

	 
	 public void insertLike(Like like);
	 public Like selectLike(Like like);
	 public Integer selectountLike(Like like);
	 public void delLike(Like like);
	 

}
