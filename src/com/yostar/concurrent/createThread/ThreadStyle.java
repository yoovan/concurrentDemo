package com.yostar.concurrent.createThread;

public class ThreadStyle extends Thread {

    public static void main(String[] args) {
        new ThreadStyle().start();
        System.out.println("run after"); // 执行结果不确定
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
