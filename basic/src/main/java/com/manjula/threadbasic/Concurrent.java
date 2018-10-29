package com.manjula.threadbasic;

public class Concurrent {

    public static void main(String[] args) {
        Thread runner1 = new Thread(new ThreadRunner("Thread-1"));
        Thread runner2 = new Thread(new ThreadRunner("Thread-2"));

        runner1.start();
        runner2.start();
    }

}

class ThreadRunner implements Runnable {

    private String name;

    ThreadRunner(String name) {
        this.name = name;
    }

    public void run() {
        for (int i = 0; i < 10; ++i) {
            System.out.printf("Name: %s %d %n", this.name, i);
        }
    }

}
