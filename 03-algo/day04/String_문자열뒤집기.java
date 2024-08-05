import java.util.Arrays;

public class String_문자열뒤집기 {

	public static void main(String[] args) {
		
		String str = new String("algorithm");
		
		char[] charArr = new char[str.length()];
		
		for (int i = 0; i < str.length(); i++) {
			charArr[i] = str.charAt(i);
		}
//		System.out.println(Arrays.toString(charArr));
		
		// 1. 새로운 배열을 만들어서 뒤집기
		
		char[] nextArr = new char[charArr.length];
		
		// 원본 배열을 정방향 순회하면서 새 배열에 뒤에서부터 써주기
		for (int i = 0; i < charArr.length; i++) {
			nextArr[(charArr.length - 1) - i] = charArr[i];
		}
		
//		System.out.println(Arrays.toString(nextArr));
		
		// 2. 원본 배열에서 swap
		char[] charArr2 = str.toCharArray();
		System.out.println(Arrays.toString(charArr2));
		
		int N = charArr2.length;
		
		for (int i = 0; i < N / 2; i++) {
			char tmp = charArr2[i];
			charArr2[i] = charArr2[N - 1 - i];
			charArr2[N - 1 - i] = tmp;	
		}
		
		System.out.println(Arrays.toString(charArr2));
		

		

	}

}
