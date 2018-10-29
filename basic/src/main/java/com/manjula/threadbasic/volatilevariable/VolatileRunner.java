package com.manjula.threadbasic.volatilevariable;

public class VolatileRunner implements Runnable {

    private volatile boolean isCompleted = false;

    public void run() {
        while (!isCompleted) {
            System.out.println("Hello world");
            sleep();
        }
    }

    private void sleep() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}
