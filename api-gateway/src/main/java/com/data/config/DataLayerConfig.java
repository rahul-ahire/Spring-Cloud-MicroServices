package com.data.config;

import org.springframework.cloud.sleuth.Sampler;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IRule;
import com.shree.apifilter.ErrorFilter;
import com.shree.apifilter.PostFilter;
import com.shree.apifilter.PreFilter;
import com.shree.apifilter.RouteFilter;

@Configuration
public class DataLayerConfig {

	IRule rule() {
//		return new RoundRobinRule(); // Default Rule
//		return new WeightedResponseTimeRule();
		return new AvailabilityFilteringRule();
	}

	@Bean
	public Sampler defaultSampler() {
	  return new AlwaysSampler();
	}
	
	@Bean
	public PreFilter preFilter() {
		return new PreFilter();
	}

	@Bean
	public PostFilter postFilter() {
		return new PostFilter();
	}

	@Bean
	public ErrorFilter errorFilter() {
		return new ErrorFilter();
	}

	@Bean
	public RouteFilter routeFilter() {
		return new RouteFilter();
	}
}
