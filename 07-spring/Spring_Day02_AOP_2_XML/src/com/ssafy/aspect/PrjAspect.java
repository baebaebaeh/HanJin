package com.ssafy.aspect;

import java.text.SimpleDateFormat;
import java.util.Date;

// 공통기능 클래스 정의하기
public class PrjAspect {
	public void after() {
		System.out.println("핵심 기능 메서드 정상 실행 후 호출되었음....");
	}
	
	public void log() {
		System.out.println(
				"Time : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())
				);
	}
}
