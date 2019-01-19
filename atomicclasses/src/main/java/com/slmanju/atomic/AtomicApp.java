package com.slmanju.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class AtomicApp {

    public static void main(String[] args) {
        Counter counter = new AtomicCounter();

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Runnable worker1 = () -> IntStream.rangeClosed(1, 100000).forEach(i -> counter.increment());
        Runnable worker2 = () -> IntStream.rangeClosed(1, 100000).forEach(i -> counter.increment());
        Runnable worker3 = () -> IntStream.rangeClosed(1, 100000).forEach(i -> counter.increment());

        long startTime = System.nanoTime();

        executorService.execute(worker1);
        executorService.execute(worker2);
        executorService.execute(worker3);

        shutdown(executorService);

        long endTime = System.nanoTime();

        System.out.println(counter.value());
        System.out.println("Time taken :: " + (endTime - startTime) / 1e+6);
    }

    private static void shutdown(ExecutorService executorService) {
        executorService.shutdown();
        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
        }
    }

}
