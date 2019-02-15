package com.upath.data.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upath.data.entity.UserInfo;
import com.upath.data.service.DataService;

@RestController
@RequestMapping("/")
public class DataController {

	@Autowired
	private DataService dataService;

	@PostMapping("/addorupdate")
	public boolean addUser(@RequestBody final UserInfo userInfo) {
		System.out.println("Data Service: addUser() called for UserInfo:" + userInfo);
		boolean respFlag = dataService.addUser(userInfo);
		System.out.println("Data Service: addUser() got response :" + respFlag);
		return respFlag;
	}

	@GetMapping("/{id}")
	public UserInfo getUser(@PathVariable("id") final int userId) {
		System.out.println("Data Service: getUser() called for UserInfo:" + userId);
		UserInfo userInfo = dataService.getUser(userId);
		System.out.println("Data Service: getUser() got response :" + userInfo);
		return userInfo;
	}
}
