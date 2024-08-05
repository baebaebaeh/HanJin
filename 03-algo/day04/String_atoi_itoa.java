
public class String_atoi_itoa {

	public static void main(String[] args) {
		
		String strNum = "52304";		
//		System.out.println(0 + strNum);
		
		
		// 문자열 -> 정수
		int num = Integer.parseInt(strNum);
//		System.out.println(0 + num);
		
		int result = atoi(strNum);
//		System.out.println(result);
		
		// 정수 -> 문자열
		
		int intVar = 324;
		String intStr = String.valueOf(intVar);
		System.out.println(intStr);
		
		//itoa(intVar)

	}
	
	static int atoi(String str) {
		int N = str.length();
		int num = 0;
		// 문자 앞에서부터 정방향 순회
		for (int i = 0; i < N; i++) {
			// 문자 하나를 c에 할당
			char c = str.charAt(i);
			// c가 정수로 표현할 수 있는 문자인가 확인
			if ('0' <= c && c <= '9') {
				num = (num * 10) + (c - '0');
			} else {
				return -99999999;
			}
		}
		return num;
	}
	
	static String itoa(int num) {
		return "";
	}

}
