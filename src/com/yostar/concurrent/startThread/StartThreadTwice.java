package com.yostar.concurrent.startThread;

public class StartThreadTwice {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        });
        thread.start();
        thread.start(); // java.lang.IllegalThreadStateException
    }
}
