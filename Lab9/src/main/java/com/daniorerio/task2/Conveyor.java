package com.daniorerio.task2;

public class Conveyor implements Runnable {
    private final CircularBuffer<String> inputBuffer;
    private final CircularBuffer<String> outputBuffer;
    private final int id;

    public Conveyor(CircularBuffer<String> inputBuffer, CircularBuffer<String> outputBuffer, int id) {
        this.inputBuffer = inputBuffer;
        this.outputBuffer = outputBuffer;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String message = inputBuffer.remove();
                String newMessage = "Потік № " + id + " переклав повідомлення: " + message;
                outputBuffer.add(newMessage);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
