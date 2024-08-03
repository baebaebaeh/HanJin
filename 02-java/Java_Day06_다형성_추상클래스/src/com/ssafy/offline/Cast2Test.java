package com.ssafy.offline;

class Food {
	String name = "Food";
	void a() {
		System.out.println("Food - a()");
	}
	void b() {
		System.out.println("Food - b()");
	}
}











class Bread extends Food {
	String name = "Bread";
	int price = -1;
	void a() {System.out.println("Bread - a()");}
	void c() {System.out.println("Bread - c()");}
}
public class Cast2Test {
	public static void main(String[] args) {
		Food f = new Bread(); 
		System.out.println(f.name);
		f.a();
		f.b();
//		System.out.println(f.price);
//		f.c();
	}
}










