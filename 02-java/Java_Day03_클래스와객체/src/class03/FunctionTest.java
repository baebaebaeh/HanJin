package class03;

import java.util.Random;

class FunctionTest {
	public static void main(String[] args) {
		System.out.println("아침에 일어난다.");
		이동("교육장", "자전거");
		boolean 과제 = 교육();
		이동("집", "대중교통");
		if(과제)
			System.out.println("과제를 해결한다.");
		System.out.println("잔다.");
		
		System.out.println("아침에 일어난다.");
		이동("교육장", "대중교통");
		과제 = 교육();
		이동("집", "두다리");
		if(과제) 
			System.out.println("과제를 해결한다.");
		System.out.println("잔다.");
		
		// 반복이 일어나고 있으니,
		// 중복을 줄이고 싶다..
	}
	
	// 함수
	// - 관련된 문장들을 하나로 묶은것.
	// - 이름을 붙인 것
	// - 실행 가능한 단위
	// - 다른 곳에서 호출할 때는 : 함수이름()
	
	// 함수의 반환값.
	// void : 이함수는 반환값이 없음
	// 함수가 반환값이 있다면
	// 반환형 함수이름() {
	//	return 반환값; // 나를 호출한 곳으로 돌아간다.
	// }
	
	public static boolean 교육() {
		System.out.println("오전 수업을 듣는다.");
		System.out.println("점심을 먹는다.");
		System.out.println("오후 실습을 한다.");
		
		// 랜덤 과제 발생기
		Random random = new Random();
		
		return random.nextBoolean();
		
	}
	
	// 함수의 매개변수
	// - 함수를 호출 할 때 값을 넣어서 호출할 수 있다.
	// - 유연한 대응이 가능.
	public static void 이동(String 장소, String 탈것) {
		System.out.println(장소+"(으)로 "+탈것+"을(를) 이용하여 이동한다.");
	}
	
	
	
	
	
}





