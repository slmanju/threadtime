package com.manjula.threadbasic.producerconsumer;

public class ProducerConsumerApp {

    public static void main(String[] args) throws InterruptedException {
        ProducerConsumer processor = new ProducerConsumer();

        Thread t1 = new Thread(() -> {
            try {
                processor.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                processor.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }

}
