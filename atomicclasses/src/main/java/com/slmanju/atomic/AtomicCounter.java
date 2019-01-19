package com.slmanju.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter implements Counter {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public void increment() {
        atomicInteger.incrementAndGet();
    }

    public void decrement() {
        atomicInteger.decrementAndGet();
    }

    public int value() {
        return atomicInteger.get();
    }

}
