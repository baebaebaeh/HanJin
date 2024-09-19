package com.ssafy.ws.step3;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


// Q. @WebServelt Annotation을 작성하고 그 경로를 "/requestTest"으로 설정해 봅시다.
// Q. MainServle에 HttpServlet을 상속받아 봅시다.
@WebServlet("/requestTest") // /requestTest로 요청 발생시 실행되는 Servlet
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
	
	// 주석을 제거하여
	// service() 메소드가 있다면, doGet, doPost 메소드가 호출되지 않음을 확인합니다.
	// service() 메소드를 Override하여 doGet, doPost를 호출할 수 없는 상태가 됩니다.
	
//	@Override
//	protected void service(HttpServletRequest request, HttpServletResponse response) 
//			throws ServletException, IOException {
//		
//		// 서버를 실행하면서 메소드 호출을 확인해 봅시다.
//		System.out.println("service() 메소드 호출.");
//		
//	}
//	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		// 서버를 실행하면서 메소드 호출을 확인해 봅시다.
		System.out.println("doGet() 메소드 호출.");
		
		
		// Q. 전송하려는 데이터 인코딩을 UTF-8로 설정해 봅시다.
		//    반드시 getWriter() 메소드가 호출되기 전에 실행되어야 합니다.
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter writer = response.getWriter();
		
		writer.println("<html>");
		writer.println("<head>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("<h1>doGet() 메소드 호출</h1>");
		writer.println("</body>");
		writer.println("</html>");
        writer.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		// 서버를 실행하면서 메소드 호출을 확인해 봅시다.
		System.out.println("doPost() 메소드 호출.");
		
		// Q. 전송하려는 데이터 인코딩을 UTF-8로 설정해 봅시다.
		//    반드시 getWriter() 메소드가 호출되기 전에 실행되어야 합니다.
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter writer = response.getWriter();
		
		writer.println("<html>");
		writer.println("<head>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("<h1>doPost() 메소드 호출</h1>");
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
