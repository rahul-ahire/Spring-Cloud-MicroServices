package com.upath.data.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.upath.data.entity.UserInfo;

public interface UserDataDao extends JpaRepository<UserInfo, Integer> {
	UserInfo findByUserName(String username);
}
