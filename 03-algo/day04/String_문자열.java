
public class String_문자열 {

	public static void main(String[] args) {

		// 문자열의 초기화
		String lStr1 = "Hello";
		String lStr2 = "Hello";

		String str1 = new String("Hello");
		String str2 = new String("Hello");

		// == 은 주소 비교	
		System.out.println(lStr1 == lStr2);
		System.out.println(str1 == str2);
		
		// equals는 값 비교
		System.out.println(lStr1.equals(lStr2));
		System.out.println(str1.equals(str2));
		

	}

}
