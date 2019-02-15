package com.shree.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.shree.rest.model.ResponseVO;
import com.shree.rest.model.UserInfoVO;

@RefreshScope
public class UserDataServiceImpl implements UserDataService {

	private final static Logger LOGGER = LoggerFactory.getLogger(UserDataServiceImpl.class);

	@Value("${dataLayerUri:data-layer}")
	private String dataLayerUri;

	@Autowired
	private RestTemplate restTemplate;

//	@Autowired
//	private LoadBalancerClient loadBalancer;

	@Override
	@HystrixCommand(fallbackMethod = "defaultFallbackCallUserById")
	public ResponseVO<UserInfoVO> getUserById(int userId) {
		LOGGER.info("UserDataServiceImpl:getUserById() :: called for userId:" + userId);

		String uri = "http://" + dataLayerUri + "/" + userId;
		LOGGER.info("UserDataServiceImpl:getUserById() :: uri :" + uri);

		ResponseEntity<UserInfoVO> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, null, UserInfoVO.class,
				new ParameterizedTypeReference<UserInfoVO>() {
				});
		LOGGER.info("UserDataServiceImpl:getUserById() :: got response:" + responseEntity.getBody());
		return ResponseVO.createSuccessResponse(responseEntity.getBody());
	}

	public ResponseVO<UserInfoVO> defaultFallbackCallUserById(int userId) {
		LOGGER.info(
				"UserDataServiceImpl:defaultFallbackCallUserById() :: *********************Inside fallback******************* ");
		return ResponseVO.createErrorResponse(null,
				"http://data-layer/ is not available to get User for userId:" + userId);
	}
}
