package com.ssafy.offline;

public class Test01Manager {
	private Test01Manager() {}
	private static Test01Manager instance = new Test01Manager();
	public static Test01Manager getInstance() {
		return instance;
	}
	
	public void info() {
		System.out.println("저는 관리하는 기능을 가지고 있습니다.");
	}
}





