package com.ssafy.offline;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class User implements Serializable {
	private String name;
	private int age;

	public User() {
	}

	public User(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + "]";
	}
}

public class IOTest2 {
	
	private static void read() {
		try (
				FileInputStream fis = new FileInputStream("data/user.dat");
				ObjectInputStream ois = new ObjectInputStream(fis);
				){
			User u = (User) ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {

		try (
				FileOutputStream fos = new FileOutputStream("data/user.dat");
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				) {
			User u1 = new User("김혜준", 24);
			oos.writeObject(u1); //위 implements Serializable 없으면 java.io.NotSerializableException 오류발생
			System.out.println("객체 정보 출력 성공함");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
