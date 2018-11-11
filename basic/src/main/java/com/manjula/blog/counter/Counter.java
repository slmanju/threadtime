package com.manjula.blog.counter;

public class Counter {

    private int count = 0;

    public synchronized int getAndIncrement() {
        return count++;
    }

    public synchronized int get() {
        return count;
    }

}
