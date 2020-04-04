package com.yostar.concurrent.createThread;

public class RunnableStyle implements Runnable {

    public static void main(String[] args) {
        new Thread(new RunnableStyle()).start();
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
