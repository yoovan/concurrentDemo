package com.yostar.concurrent.startThread;

/**
 * 展示线程的start()和run()方法
 */
public class StartAndRunThreadMethod {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName());
        };
        runnable.run(); // main
        new Thread(runnable).start(); // Thread-0
    }
}
