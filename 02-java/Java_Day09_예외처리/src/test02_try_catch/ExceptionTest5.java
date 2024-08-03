package test02_try_catch;

public class ExceptionTest5 {
	public static void main(String[] args) {
		
		int[] nums = {10};
	
		try {
			System.out.println("정상 코드 1");
			System.out.println(nums[3]); // ArrayIndexOutOfBounds..
			int i = 1 / 0; // Java에서는 숫자를 0으로 나누면 예외 발생 -> ArithmeticException
			System.out.println("정상 코드 2"); 
		}  catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			// 모든 예외 메시지를 확인할 수 있으면서도..
			// 프로그램은 정상 종료되었다.
			System.out.println("모든 예외 처리 가능.");
		}

		
		
		System.out.println("프로그램 종료"); 
	}
}
