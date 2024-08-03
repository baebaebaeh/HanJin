package test02_try_catch;

public class ExceptionTest3 {
	public static void main(String[] args) {
		
		int[] nums = {10};
		
		// try ... catch ... catch
		// - catch문은 여러개가 올 수 있다.
		
		
		try {
			System.out.println("정상 코드 1");
			System.out.println(nums[0]); // ArrayIndexOutOfBounds..
			int i = 1 / 0; // Java에서는 숫자를 0으로 나누면 예외 발생 -> ArithmeticException
			System.out.println("정상 코드 2"); 
		} catch (ArrayIndexOutOfBoundsException | ArithmeticException e) { 
			System.out.println("둘 중 한 예외 발생."); 
		} 
		System.out.println("프로그램 종료"); 
	}
}
