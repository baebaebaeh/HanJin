package offline;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Car implements Comparable {
	String name;
	int price;
	
	public Car(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
	
	
	@Override
	public String toString() {
		return "Car [name=" + name + ", price=" + price + "]";
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
}

public class SortTest {
	public static void main(String[] args) {
		Car c1 = new Car("제네시스 gv80", 8000);
		Car c2 = new Car("BMW X6", 8000);
		Car c3 = new Car("아우디 R8", 8000);
		Car c4 = new Car("롤스로이스 팬텀", 8000);
		List<Car> = new ArrayList<>();
		
		list.add(c1);
		list.add(c2);
		list.add(c3);
		list.add(c4);
		
		Collections.sort(list, CarComp());
		
	}
	static class CarComp implements Comparator<Car> {
		
		
	}
}
