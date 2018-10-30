package com.manjula.blog.counter;

import java.util.stream.IntStream;

public class CounterApp {

	public static void main(String[] args) throws InterruptedException {
		Counter counter = new Counter();
		
		Thread thread1 = new Thread(() -> IntStream.range(0, 100).forEach(i -> counter.incrementAndGet()));
        Thread thread2 = new Thread(() -> IntStream.range(0, 100).forEach(i -> counter.incrementAndGet()));
        
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Count: " + counter.get());
	}

}
