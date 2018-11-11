package com.manjula.threadbasic.threadlocal;

public class ThreadLocalApp {

    public static void main(String[] args) throws InterruptedException {
        TimeHolder timeHolder = new TimeHolder();
        
        timeHolder.print();
        
        Thread t1 = new Thread(() -> timeHolder.print());
        t1.start();
        t1.join();
        
        timeHolder.print();
        
        Thread t2 = new Thread(() -> {
            timeHolder.set();
            timeHolder.print();
        });
        t2.start();
        t2.join();
        
        timeHolder.print();
        
        timeHolder.set();
        timeHolder.print();
    }

}
