package com.yostar.concurrent.createThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsStyle {
    public static void main(String[] args) {
        // 创建线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            executorService.submit(new RunnableTask() {
            });
        }
        // 停止线程池
        executorService.shutdown();
    }
}

class RunnableTask implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }
}
