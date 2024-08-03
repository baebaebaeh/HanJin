package test05_object_serialization;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializationTest2 {
	public static void main(String[] args) {
		Person p = new Person("luna", 5);
		Student s = new Student("max", 3, "Java");
		
		// 객체 => 파일에 저장
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("max.dat"))){
			
			oos.writeObject(s);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
