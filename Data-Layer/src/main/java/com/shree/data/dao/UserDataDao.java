package com.shree.data.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shree.data.entity.UserInfo;

public interface UserDataDao extends JpaRepository<UserInfo, Integer> {
	UserInfo findByUserName(String username);
}
