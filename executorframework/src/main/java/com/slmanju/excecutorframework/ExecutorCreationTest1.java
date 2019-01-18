package com.slmanju.excecutorframework;

import java.util.concurrent.*;

public class ExecutorCreationTest1 {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> System.out.println("running with executors"));

        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.schedule(() -> System.out.println("running with a delay"), 1, TimeUnit.MINUTES);

        executorService.shutdown();
        scheduledExecutorService.shutdown();
    }

}
