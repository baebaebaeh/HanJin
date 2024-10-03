package net.acmicpc.num17837;

import java.io.*;
import java.util.*;

public class num17837_refact2 {
	static Deque<Integer> d;
	public static void main(String[] args) {
		d = new ArrayDeque<>();
		d.add(1);
		d.add(2);
		d.add(3);
		System.out.println(d.peek());
		System.out.println(d.pollLast());
		System.out.println(d.poll());
		
	}
}
