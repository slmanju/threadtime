package com.manjula.blog.counter;

public class Counter {
	
	private int count = 0;
	
	public int incrementAndGet() {
		return count++;
	}
	
	public int get() {
		return count;
	}
	
}
