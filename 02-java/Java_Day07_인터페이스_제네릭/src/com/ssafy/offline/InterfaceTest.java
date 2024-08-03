package com.ssafy.offline;

import java.util.ArrayList;
import java.util.List;

class WebServer implements Server {

	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void restart() {
		// TODO Auto-generated method stub
		
	}
//	 구현받은 Server의 인터페이스의 모든 추상메서드를 오버라이드 해야한다.
}

public class InterfaceTest {
	public static void main(String[] args) {
//		Server s = new Server(); 안됨
		Server s = new WebServer();
		s.start();
		s.restart();
		s.stop();
//		위와같이 webserver가 아니더라도
//		offlineserver라던가
//		다른 서버도 Server를 구현받아서
//		Server a = new OfflineServer();
//		a.start();
//		a.restart();
//		a.stop();
//		와 같이 같은 메서드로 작동된다
		
		System.out.println(Server.PORT); // 이렇게 final을 다뤄줘야함
		
		List<String> list = new ArrayList<>();
		list.add("1번");
		list.add("2번");
		list.add("3번");
		
		// 아래는 List를 컨트롤 클릭으로 확인후 만들어볼 수 있다.
		boolean b = list.isEmpty();
		System.out.println(list.size());
		System.out.println(list.isEmpty() ? "리스트는 비어있음" : "리스트는 비어있지 않다");
		System.out.println(list);
		
	}
}
