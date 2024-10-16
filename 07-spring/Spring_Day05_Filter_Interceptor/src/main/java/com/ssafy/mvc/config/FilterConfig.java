package com.ssafy.mvc.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ssafy.mvc.filter.AFilter;
import com.ssafy.mvc.filter.MyFilter;
import com.ssafy.mvc.filter.MyFilter2;

@Configuration
public class FilterConfig {
	@Bean
	public FilterRegistrationBean<MyFilter> myfilter(){
		FilterRegistrationBean<MyFilter> registrationBean = new FilterRegistrationBean<>();
		
		registrationBean.setFilter(new MyFilter()); //어떤 필터를...
		registrationBean.addUrlPatterns("/hello");  //어떤 경로로...
		registrationBean.setOrder(1); 				//어떤 순서로...
		
		return registrationBean;
	}
	@Bean
	public FilterRegistrationBean<MyFilter2> myfilter2(){
		FilterRegistrationBean<MyFilter2> registrationBean = new FilterRegistrationBean<>();
		
		registrationBean.setFilter(new MyFilter2()); //어떤 필터를...
		registrationBean.addUrlPatterns("/hello");  //어떤 경로로...
		registrationBean.setOrder(2); 				//어떤 순서로...
		
		return registrationBean;
	}
	@Bean
	public FilterRegistrationBean<AFilter> myfilter3(){
		FilterRegistrationBean<AFilter> registrationBean = new FilterRegistrationBean<>();
		
		registrationBean.setFilter(new AFilter()); //어떤 필터를...
		registrationBean.addUrlPatterns("/hello");  //어떤 경로로...
		registrationBean.setOrder(3); 				//어떤 순서로...
		
		return registrationBean;
	}
}
