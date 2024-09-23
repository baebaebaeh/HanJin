package com.ssafy.servlet.basic;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*
web.xml
<servlet>
	<servlet-name>aaaa</servlet-name>
	<servlet-class>com.ssafy.servlet.basic.ServletBasic</servlet-class>
</servlet>
<servlet-mapping>
	<servlet-name>aaaa</servlet-name>
	<url-pattern>/servlet/basic</url-pattern>
</servlet-mapping>
 */
@WebServlet("/servlet/basic")
public class ServletBasic extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("my - service ");
	}
}









