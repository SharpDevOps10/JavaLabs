package com.daniorerio.task2;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        CircularBuffer<String> buffer1 = new CircularBuffer<>(10);
        CircularBuffer<String> buffer2 = new CircularBuffer<>(10);

        Thread[] producers = new Thread[5];
        for (int i = 0; i < 5; i++) {
            producers[i] = new Thread(new Producer(buffer1, i + 1));
            producers[i].setDaemon(true);
            producers[i].start();
        }

        Thread[] conveyors = new Thread[2];
        for (int i = 0; i < 2; i++) {
            conveyors[i] = new Thread(new Conveyor(buffer1, buffer2, i + 1));
            conveyors[i].setDaemon(true);
            conveyors[i].start();
        }

        for (int i = 0; i < 100; i++) {
            String message = buffer2.remove();
            System.out.println(message);
        }
    }
}