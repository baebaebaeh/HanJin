<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	//화면을 보여줄건 아니야 그래서 HTML 코드는 필요없어!
	
	String id = request.getParameter("id");
	String pw = request.getParameter("password");
	
	//id, pw 를 이용하여 실제 유저인지 확인을 해야한다. (DB배우고 나서야 명확하게 할 수 있다.)
	//혹은 Manager 라는 걸 통해서 유저 목록을 관리하면서 확인을 해볼 수 있다.
	
	//조건문을 통해서 확인하겠다 ㅠ(임시)
	//"ssafy".equals(id)
	if(id.equals("ssafy") && pw.equals("1234")){
		//로그인 성공 (어디에 저장?)
		//JSP에서는 session 이라고 하는 기본객체가 이미 들어 있어!
		session.setAttribute("userid", id);
		//Servlet 이었다면 session을 가져오는 방법은?
		//쿠키목록을 전부 가져와서 JSESSIONID 이름을 가진 쿠키가 있는지 확인하고
		//해당 쿠키를 이용하여 세션ID를 확보하고, 가지고 온다....
		HttpSession mySession = request.getSession();
				
		//Main.jsp 페이지 이동을 할건데...(리다이렉트)
		
		//1. 포워딩
		//request.getRequestDispatcher("08_Main.jsp").forward(request, response);
		//2. 리다이렉트
		response.sendRedirect("08_Main.jsp");
		
	}else{
		//로그인 실패
		response.sendRedirect("07_LoginForm.jsp");
	}
	


%>
    
    
    
    