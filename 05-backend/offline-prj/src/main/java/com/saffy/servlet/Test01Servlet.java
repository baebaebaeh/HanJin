package com.saffy.servlet;

import java.io.IOException;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;

// 서블릭 클래스를 호출할 수 있게 주소 설정
// 서블릿의 주소 설정시 "/"로 시작하게 만들자.. 안만들면 문제 발생(확장자 패턴 제외)
// URL로 설정된 주소를 호출

// protocol://host:port/프로젝트주소/기능주소
// http://localhost:8080/offline-prj/test01
@WebServlet("/test01")
public class Test01Servlet implements Servlet {
	// 실행시 호출 되는 메서드 : 톰켓 서버에 의해서 자동으로 호출
	// servlet에게 상속받아야 한다.
	
	@Override
	public void destroy() {
		
	}

	@Override
	public ServletConfig getServletConfig() {
		return null;
	}

	@Override
	public String getServletInfo() {
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		
	}

	// service 메서드를 많이 쓴다.
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		System.out.println("서비스 메서드 호출됨...");
	}
}
