package com.shree.data.service;

import com.shree.data.entity.UserInfo;

public interface DataService {
	boolean addUser(UserInfo userInfo);

	UserInfo getUser(int userId);
}
