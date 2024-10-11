package com.ssafy.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

// xml대신쓸꺼야 환경설정 파일이야
@Configuration
@ComponentScan(basePackages = {"com.ssafy.aspect", "com.ssafy.board"}) //<context:component-scan base-package="com.ssafy.aspect, com.ssafy.board" />
@EnableAspectJAutoProxy //<aop:aspectj-autoproxy />
public class AopConfig {
	
}
