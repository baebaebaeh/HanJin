package com.ssafy.exam;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 원래는 /board-step01-mvc도 붙여줘야 하는데 항상 같은 부분이니 추론가능해서 생략
// dispatcher도 마찬가지
@WebServlet("/main")
public class MainController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// main.jsp 페이지로 이동하고 싶다.
		// 두가지 방식이 있다. 하나는 forward 하나는 redirect
		// forward - Request 객체 이용
		// redirect - Response 객체 이용
		// 1. forward 방식 이용하기
		//   - 동일한 프로젝트내의 페이지로 이동
		//   - RequestDispatcher 객체를 얻기 (forward 할 수 있는 객체가 있기 때문)
		//   - 객체.forward 메서드 호출 (하면 페이지 이동)
		//   - ContextRoot Path 경로는 제외한 주소를 쓴다.
		//   - page 주소 설정시 "/"로 시작하지 않도록 작성
		
		// 같은 프로젝트 내의 이동할 주소를 준다.
//		RequestDispatcher rd = req.getRequestDispatcher("/main.jsp");
		// 또는
//		RequestDispatcher rd = req.getRequestDispatcher("main.jsp");
		// "/"를 붙이면 처음 "/"부터 overwrite
		// "/"를 안붙이면 마지막 "/"부터 overwrite
//		rd.forward(req, resp);
		// forward 방식
		// http://localhost:8080/board-step01-mvc/main          req, res 생성
		// http://localhost:8080/board-step01-mvc/main.jsp      req, res 동일한 객체 전달
		
		// 2. redirect 방식
		//   - 응답객체의 sendRedirect 메서드 사용
		//   - 다른 프로젝트, 타 사이트로 이동이 가능하다.
		//   - 위에서 내 프로젝트주소(/board-step01-mvc)를 생략할 수 있었던 이유는 추론이 가능했었던건데
		//   - 추론이 불가능 해진다. 그럼 프로젝트 주소까지 작성해 줘야 한다.
		//   - 호출된 주소가 모두 노출된다. (.jsp는 보이기 싫다)
		//   - 요청이 2번 발생한다. (요청시에 만들어진 req객체가 다르기 때문에 req에 등록된 정보를 사용할 수 없다)
		//   - 응답코드를 302번으로 설정, Location 헤더의 값으로 페이지 주소를 넘겨준다.
		
//		resp.sendRedirect("/board-step01-mvc/main.jsp");
		// 또는
		resp.sendRedirect("main.jsp");
		// forward 방식
		// http://localhost:8080/board-step01-mvc/main          req, res 생성
		// http://localhost:8080/board-step01-mvc/main.jsp      req, res 새로운 객체 생성 후 전달
	}
}
