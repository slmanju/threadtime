package com.manjula.threadbasic.synchronization;

import java.util.function.IntConsumer;
import java.util.stream.IntStream;

public class Counter {

    private int count = 0;

    private final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        counter.process();
    }

    private void process() throws InterruptedException {
        IntConsumer intConsumer = (i) -> {
            sleep();
//            count++; // this will not give 200

//            increment(); // solution 1: synchronized method

//            synchronized (this) { // solution 2: synchronized block
//                count++;
//            }

            synchronized (lock) { // solution 3: synchronized block with separate lock object
                count++;
            }
        };
        Thread t1 = new Thread(() -> IntStream.range(0, 100).forEach(intConsumer));
        Thread t2 = new Thread(() -> IntStream.range(0, 100).forEach(intConsumer));

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Count: " + count);
    }

    private synchronized void increment() {
        count++;
    }

    private void sleep() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
