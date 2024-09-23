package com.ssafy.servlet;
abstract class GS {
	public void init() {
		System.out.println("GS - init");
	}
	abstract void service();
}
class HS extends GS {
	public void service() {
		System.out.println("HS - service");
	}	
}
class MS extends HS {
	public void service() {
		System.out.println("MS - service");
	}
}
class TomcatService {
	public static void main(String[] args) {
		HS hs = new MS();
		hs.init();
		hs.service();
	}
}











