package com.shree.service;

import org.springframework.stereotype.Service;

import com.shree.rest.model.ResponseVO;
import com.shree.rest.model.UserInfoVO;


@Service
public interface UserDataService {

	ResponseVO<UserInfoVO> getUserById(int userId);
}
