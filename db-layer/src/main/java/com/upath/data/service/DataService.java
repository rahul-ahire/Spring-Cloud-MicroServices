package com.upath.data.service;

import com.upath.data.entity.UserInfo;

public interface DataService {
	boolean addUser(UserInfo userInfo);

	UserInfo getUser(int userId);
}
