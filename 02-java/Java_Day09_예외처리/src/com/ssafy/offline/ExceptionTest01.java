package com.ssafy.offline;

class MyClose implements AutoCloseable { //아래에

	@Override
	public void close() throws Exception {
		System.out.println("MyClose close()");
		
	}
}

public class ExceptionTest01 {
	public static void main(String[] args) {
		System.out.println(1);
		try (MyClose mc = new MyClose()) { 	
							// 여기 리소스는 닫지 않아도 자동으로 닫아줄께 a.close로 해주겠다.
							// 그러면 close메서드가 없으면 어떡하지?
							// 그래서 AutoCloseable을 구현받는 애들만 resource자리에 올 수 잇따. 1.7버전 이후 가능
			System.out.println(2);
		} catch (Exception e) {
			System.out.println(3);
		}
		System.out.println(4);  //2와 4사이에 MyClose close()가 실행된걸 볼 수 있다.
								// 즉 저때 자동으로 닫혔구나 라고 알 수 있다.
	}
}
