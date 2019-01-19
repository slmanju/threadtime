package com.slmanju.atomic;

import java.util.stream.IntStream;

public class SimpleApp {

    public static void main(String[] args) {
        Counter counter = new SimpleCounter();

        long startTime = System.nanoTime();

        IntStream.rangeClosed(1, 100000).forEach(i -> counter.increment());
        IntStream.rangeClosed(1, 100000).forEach(i -> counter.increment());
        IntStream.rangeClosed(1, 100000).forEach(i -> counter.increment());

        long endTime = System.nanoTime();

        System.out.println(counter.value());
        System.out.println("Time taken :: " + (endTime - startTime) / 1e+6);
    }

}
