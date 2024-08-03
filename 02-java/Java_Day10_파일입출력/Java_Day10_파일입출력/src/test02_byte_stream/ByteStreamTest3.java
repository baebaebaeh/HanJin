package test02_byte_stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamTest3 {
	public static void main(String[] args) {
		// try with resources
		
		try(FileInputStream fis = new FileInputStream("dog.jpg");
			FileOutputStream fos = new FileOutputStream("dog-copy-3.jpg");
			){
			
			int b; // 버퍼에 쓴 바이트의 개수!!!
			// 버퍼를 이용해서 read()
			byte[] buffer = new byte[10];
			
			while((b = fis.read(buffer)) != -1) { // 입력스트림으로부터 버퍼에 바이트를 채운다음
				// 채운 바이트의 수를 반환.
//				System.out.println(b);
				fos.write(buffer, 0, b);
			}
			System.out.println("끝.");
			
		} catch(IOException e) {
			
		}
		System.out.println("스트림은 알아서 닫혔습니다.");
		
	}
}
