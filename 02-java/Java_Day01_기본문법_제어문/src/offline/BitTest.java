package offline;

public class BitTest {
	public static void main(String[] args) {
		{
			byte i = 5;   // 00000101 
			byte j = 3;   // 00000011
			System.out.println(i | j);	// 특정 비트를 설정할 때 
			System.out.println(i & j);	// 특정 비트가 설정되어 있는지 판단
			System.out.println(i << 2);  // 00000101 -> 00010100
			
			byte a = 5;  // 00000101   // 1 -> 00001000
			a |= 2;    
			
			byte b = 5;  // 00000101   // 2 -> 00000010
			b &= 2;
		}
		
		
		{
			/*
			// 00000101
			byte i = 5;
			
			// 음수로 변환
			// - 비트반전(0을 1로, 1을 0으로)
			// - 반전된 비트 값에 1을 더한다.
			// 11111010
			
			// 01111111
			// 10000000
			byte b = 127;
			System.out.println(~b);
			
			// 00000010
			byte j = 2;
			
			System.out.println(~i);
			*/
		}
	}
}
