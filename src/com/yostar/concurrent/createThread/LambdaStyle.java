package com.yostar.concurrent.createThread;

public class LambdaStyle {

    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName());
        }).start();
    }
}
