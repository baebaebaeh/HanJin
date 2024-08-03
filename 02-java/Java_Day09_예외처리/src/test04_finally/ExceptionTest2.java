package test04_finally;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionTest2 {
	public static void main(String[] args) {
		// try ~ catch ~ finally => try with resources
		// 가비지 컬렉터: JVM 메모리 구조
		// .. 쓰이지 않는 객체를 알아서 정리해준다.
		
		
		FileInputStream fis = null;
		
		try {
			// 이 블록 안에서 선언된 변수 => 이 블록 안에서만 쓸 수 있음.
			fis = new FileInputStream("test.txt");
			
			// 메인 로직 작성.
			
		} catch (FileNotFoundException e) {
			System.out.println("예외가 발생했어요.");
		} finally {
			try {
				if(fis != null)
					fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try(FileInputStream fis2 = new FileInputStream("test.txt")){
			// 메인 로직 작성.
		} catch (IOException e) {
			System.out.println("예외가 발생했어요.");
		}
		
		
		
	}
}
