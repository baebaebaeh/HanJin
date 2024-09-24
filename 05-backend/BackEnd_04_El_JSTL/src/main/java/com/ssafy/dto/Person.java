package com.ssafy.dto;

import java.io.Serializable;
import java.util.Arrays;

public class Person implements Serializable {
	// 1로 하면 기본형이 int형 1L이면 기본형이 long
	// 1L이면 테스트용이다?
	private static final long serialVersionUID = 1L;
	
	private String name;
	private int age;
	private String gender;
	private String[] hobbies;
	

	public Person() {}

	public Person(String name, int age, String gender, String[] hobbies) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.hobbies = hobbies;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String[] getHobbies() {
		return hobbies;
	}

	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", gender=" + gender + ", hobbies=" + Arrays.toString(hobbies)
				+ "]";
	}
}
