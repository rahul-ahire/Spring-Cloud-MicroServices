package com.shree.data.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shree.data.controller.DataController;
import com.shree.data.dao.UserDataDao;
import com.shree.data.entity.UserInfo;

@Service
public class DataServiceImpl implements DataService {

	private final static Logger LOGGER = LoggerFactory.getLogger(DataController.class);
	
	@Autowired
	private UserDataDao userDataDao;

	@Override
	public boolean addUser(UserInfo userInfo) {
		LOGGER.info("addUser(): called");
		return userDataDao.save(userInfo) != null;
	}

	@Override
	public UserInfo getUser(int userId) {
		LOGGER.info("getUser(): called");
		return userDataDao.findOne(userId);
	}

}
