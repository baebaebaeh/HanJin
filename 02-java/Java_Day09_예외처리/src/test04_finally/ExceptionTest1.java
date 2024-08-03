package test04_finally;

public class ExceptionTest1 {
	public static void main(String[] args) {
		
		// try ... catch ... finally
		
		int[] nums = {10};
		
		// try ... catch ... finally
		// 1. 정상적으로 실행되는 경우: 1 2 4 5
		// 2. 예외 발생 & 처리가 되는 경우 : 1 3 4 5
		// 3. 예외 발생 & 처리가 안되는 경우 : 1 4 (비정상적 종료)
		// 4. 정상 실행 & try문에 return이 있는 경우: 1 2 4
		// 5. 예외 발생 & 처리 & catch문에 return이 있는 경우 :  1 3 4

		try {
			System.out.println("1");
			nums[3] = 40;
//			int i = 1/1;
			System.out.println("2");
//			return; // 메서드를 종료.

		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("3");
			return;
		} finally {
			System.out.println("4");
		}
		System.out.println("5"); 
	}
}
