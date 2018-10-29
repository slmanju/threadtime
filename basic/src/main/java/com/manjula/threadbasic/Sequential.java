package com.manjula.threadbasic;

public class Sequential {

    public static void main(String[] args) {
        Runner runner1 = new Runner("R1");
        Runner runner2 = new Runner("R2");

        runner1.run();
        runner2.run();
    }

}

class Runner {

    private String name;

    Runner(String name) {
        this.name = name;
    }

    public void run() {
        for (int i = 0; i < 10; ++i) {
            System.out.printf("Name: %s %d %n", this.name, i);
        }
    }

}
