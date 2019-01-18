package com.slmanju.sdf;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        testJava8();
    }

    private static void testJava8() {
        final String source = "2019-01-11";

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        System.out.println(":: parsing date string ::");
        IntStream.rangeClosed(0, 20)
                .forEach(i -> executorService.submit(() -> System.out.println(DateUtilsJava8.parse(source))));

        executorService.shutdown();
    }

    private static void testThreadLocal() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        final String source = "2019-01-11";

        System.out.println(":: parsing date string ::");
        IntStream.rangeClosed(0, 20)
                .forEach(i -> executorService.submit(() -> System.out.println(DateUtilsThreadLocal.parse(source))));

        executorService.shutdown();
    }

    private static void testSimpleDateFormatWithThreads() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        final String source = "2019-01-11";

        System.out.println(":: parsing date string ::");
        IntStream.rangeClosed(0, 20)
                .forEach((i) -> executorService.submit(() -> System.out.println(DateUtils.parse(source))));

        System.out.println(":: parsing date ::");
        IntStream.rangeClosed(1, 20)
                .forEach((i) -> executorService.submit(() -> {
                    Date date = new Date();
                    date.setDate(i);
                    System.out.println(DateUtils.format(date));
                }));

        executorService.shutdown();
    }

    private static void testSimpleDateFormatInSingleThread() {
        final String source = "2019-01-11";
        System.out.println(DateUtils.parse(source));
    }

}
