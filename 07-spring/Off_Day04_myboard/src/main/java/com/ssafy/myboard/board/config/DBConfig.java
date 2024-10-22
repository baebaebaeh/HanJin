package com.ssafy.myboard.board.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.ssafy.myboard.board.model.dao")
public class DBConfig {

}
