package com.upath.data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upath.data.dao.UserDataDao;
import com.upath.data.entity.UserInfo;

@Service
public class DataServiceImpl implements DataService {

	@Autowired
	private UserDataDao userDataDao;

	@Override
	public boolean addUser(UserInfo userInfo) {
		return userDataDao.save(userInfo) != null;
	}

	@Override
	public UserInfo getUser(int userId) {
		return userDataDao.findOne(userId);
	}

}
