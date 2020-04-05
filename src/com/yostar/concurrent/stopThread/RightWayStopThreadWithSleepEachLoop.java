package com.yostar.concurrent.stopThread;

public class RightWayStopThreadWithSleepEachLoop {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                // 查找0-300内100的倍数，然后睡眠1秒
                int num = 0;
                while (num <= 10000 && !Thread.currentThread().isInterrupted()) {
                    if (num % 100 == 0) {
                        System.out.println(num + "是100的倍数");
                    }
                    num++;
                    Thread.sleep(10);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("任务执行结束");
            }

        });
        thread.start();
        Thread.sleep(5000);
        thread.interrupt();
    }
}
