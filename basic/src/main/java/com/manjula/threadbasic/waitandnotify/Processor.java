package com.manjula.threadbasic.waitandnotify;

public class Processor {

    public void produce() throws InterruptedException {
        synchronized (this) {
            System.out.println("in the produce method");
            wait(); // pass the lock to the other method
            System.out.println("again in the product method");
        }
    }

    public void consume() throws InterruptedException {
        Thread.sleep(1000);

        synchronized (this) {
            System.out.println("in the consume method");
            notify(); // i'm done. you can wake up
        }
    }

}
