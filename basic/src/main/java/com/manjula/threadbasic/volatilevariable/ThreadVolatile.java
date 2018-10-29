package com.manjula.threadbasic.volatilevariable;

public class ThreadVolatile {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Task started....");

        VolatileRunner runner = new VolatileRunner();
        Thread thread1 = new Thread(runner);

        thread1.start();

        Thread.sleep(100); // sleep main thread

        runner.setCompleted(true);

        System.out.println("Task completed...");
    }

}

