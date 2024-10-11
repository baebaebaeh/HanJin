package com.ssafy.aspect;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

// 공통기능 클래스 정의하기
//<aop:aspect ref="prjAspect">
@Aspect
@Component
public class PrjAspect {
	
	//<aop:pointcut expression="execution(* com.ssafy.board.model.service.BoardServiceImpl.*(..))"
	//	id="pCut"/>
	// id 가 메서드 이름
	@Pointcut("execution(* com.ssafy.board.model.service.BoardServiceImpl.*(..))")
	public void pCut() {}
	
	//<aop:after-returning method="after" pointcut-ref="pCut"/>
	@AfterReturning("pCut()")
	public void after() {
		System.out.println("핵심 기능 메서드 정상 실행 후 호출되었음....");
	}
	
	//<aop:before method="log" pointcut-ref="pCut"/>
	@Before("pCut()")
	public void log() {
		System.out.println(
				"Time : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())
				);
	}
}
