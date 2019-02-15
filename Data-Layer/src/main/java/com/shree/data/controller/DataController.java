package com.shree.data.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shree.data.entity.UserInfo;
import com.shree.data.service.DataService;

@RestController
@RequestMapping("/")
public class DataController {

	private final static Logger LOGGER = LoggerFactory.getLogger(DataController.class);
	
	@Autowired
	private DataService dataService;

	@PostMapping("/addorupdate")
	public boolean addUser(@RequestBody final UserInfo userInfo) {
		LOGGER.info("Data Service: addUser() called for UserInfo:" + userInfo);
		boolean respFlag = dataService.addUser(userInfo);
		LOGGER.info("Data Service: addUser() got response :" + respFlag);
		return respFlag;
	}

	@GetMapping("/{id}")
	public UserInfo getUser(@PathVariable("id") final int userId) {
		LOGGER.info("Data Service: getUser() called for UserInfo:" + userId);
		UserInfo userInfo = dataService.getUser(userId);
		LOGGER.info("Data Service: getUser() got response :" + userInfo);
		return userInfo;
	}
}
