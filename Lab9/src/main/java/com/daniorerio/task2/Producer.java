package com.daniorerio.task2;

import java.util.concurrent.ThreadLocalRandom;

public class Producer implements Runnable {
    private final CircularBuffer<String> buffer;
    private final int id;

    public Producer(CircularBuffer<String> buffer, int id) {
        this.buffer = buffer;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String message = "Потік № " + id + " згенерував повідомлення";
                buffer.add(message);
                Thread.sleep(ThreadLocalRandom.current().nextInt(100, 500));
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}