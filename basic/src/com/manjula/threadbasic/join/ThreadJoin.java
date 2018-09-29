package com.manjula.threadbasic.join;

public class ThreadJoin {

    public static void main(String[] args) {
        System.out.println("Task started....");

        Thread runner1 = new Thread(new ThreadRunner("R1"));
        Thread runner2 = new Thread(new ThreadRunner("R2"));

        runner1.start();
        runner2.start();

        try {
            runner1.join(); // wait for thread to die
            runner2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Task completed...");
    }

}

class ThreadRunner implements Runnable {

    private String name;

    ThreadRunner(String name) {
        this.name = name;
    }

    public void run() {
        for (int i = 0; i < 100; ++i) {
            System.out.printf("Name: %s %d %n", this.name, i);
            sleep();
        }
    }

    private void sleep() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
