package offline;

public class 단항연산자Test {
	public static void main(String[] args) {
		{
			int a = 5;
			/*
			 * a = a + 1
			 * System.out.println(a)
			 */
			System.out.println(++a);  // 6
			System.out.println(a++);  // 6
			System.out.println(a);    // 7
			System.out.println(--a);  // 6 
			System.out.println(a--);  // 6
		}
		{
			int a = 5;
			/*
			 *   a = a + 1;
			 *   b = a;
			 */
			int b = ++a;
			
			/*
			 * c = a;
			 * a = a + 1;
			 */
			int c = a++;
			
			System.out.println(a + "," + b + "," + c);
		}
	}
}
