package com.ssafy.offline;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class IOTest01 {
	public static void main(String[] args) {
		try (
				FileInputStream fis = new FileInputStream("data/dog.jpg");
				BufferedInputStream bis = new BufferedInputStream(fis);
				FileOutputStream fos = new FileOutputStream("data/dog1.jpg");
				BufferedOutputStream bos = new BufferedOutputStream(fos);
		) {
			while (true) {
				int ch = bis.read(); // 계속 읽다가 읽을게 없으면 -1을 반환한다.
				if (ch == -1) break; // fos에 -1값을 주면 안되니까 멈춰준다.
				bos.write(ch);				
			}
			System.out.println("복사완료");
		}
			catch (Exception e) {
				e.printStackTrace();
		}
	}
}
