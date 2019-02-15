package com.shree.rest;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.Span;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shree.rest.model.ResponseVO;
import com.shree.rest.model.UserInfoVO;
import com.shree.service.UserDataService;

@RestController
@RequestMapping("/")
public class ApiOneController {

	private final static Logger LOGGER = LoggerFactory.getLogger(ApiOneController.class);

	@Autowired
	private Tracer tracer;

	@Autowired
	UserDataService userService;

	@GetMapping("/{id}")
	public ResponseVO<UserInfoVO> getUserById(@PathVariable("id") final int userId) {
		LOGGER.info("ApiOneController:getUserById() :: called for userId:" + userId);
		ResponseVO<UserInfoVO> resp = userService.getUserById(userId);
		customSpan();
		return resp;
	}

	private void customSpan() {
		Span span = tracer.createSpan("custom-span");
		try {
			tracer.addTag("custom-key", "Rest-contoller");
//			Thread.sleep(100);
			span.logEvent("custom_evt_1");
//			Thread.sleep(120);
			span.logEvent("custom_evt_2");
//			Thread.sleep(180);
			span.logEvent("custom_evt_3");
//			Thread.sleep(200);
			span.logEvent("custom_evt_n");
//			Thread.sleep(500);
			span.logEvent(new Date().getTime(), "custom_evt_1");
		} finally {
			tracer.close(span);
		}
	}
}
