package com.ssafy.ws.step1;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletConfig;

// Q. @WebServlet Annotation을 작성하고 그 경로를 "/welcome"으로 설정해 봅시다.
// Q. MainServle에 HttpServlet을 상속받아 봅시다.
@WebServlet("/welcome") // /welcome으로 요청 발생시 실행되는 Servlet
public class MainServlet extends HttpServlet {
	
	// 서버를 실행하면서 메소드 호출을 확인해 봅시다.
	public MainServlet( ) {
		System.out.println("Servlet 생성자 호출.");
	}
	
	// 서버를 실행하면서 메소드 호출을 확인해 봅시다.
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init() 메소드 호출.");
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		// Q. response 객체에서 getWriter() 메소드를 호출해 봅시다.
		PrintWriter writer = response.getWriter();
		
		writer.println("<html>");
		writer.println("<head>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("<h1>Hello, SSAFY</h1>");
		writer.println("</body>");
		writer.println("</html>");
        writer.close();
        
	}
	
	// 서버를 실행하면서 메소드 호출을 확인해 봅시다.
		@Override
		public void destroy() {
			// 호출을 확인하고자 하는 경우 띄어쓰기를 붙여 코드를 수정하고 저장해 봅시다. 
			System.out.println("destroy() 메소드 호출.");
		}
}
