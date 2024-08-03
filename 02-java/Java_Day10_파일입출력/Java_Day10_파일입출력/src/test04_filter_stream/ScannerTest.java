package test04_filter_stream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ScannerTest {
	public static void main(String[] args) {
		method2();
		method3();
	}
	
	private static void method3() {
		try (Scanner sc = new Scanner(new FileInputStream("big_input.txt"))){
			long start = System.nanoTime();
			
			while(sc.hasNext()) {
				int num =sc.nextInt();
			}
			long end = System.nanoTime();
			System.out.println("Scanner");
			System.out.println(end - start);
			
		} catch(IOException e) {
			
		}
		
	}

	// method2: BufferedReader를 쓴 경우.
	private static void method2() {
		try(BufferedReader reader = new BufferedReader(new FileReader("big_input.txt"))	){
			long start = System.nanoTime();
			String line; // BufferedReader는 입력을 줄 단위로 받는다.
			while((line = reader.readLine())!= null) {
				int num = Integer.parseInt(line); // 문자를 정수로 형변환해서 사용.
			}
			long end = System.nanoTime();
			System.out.println(end - start);
			
		} catch (IOException e) {
			
		}
	}
	
	
}
