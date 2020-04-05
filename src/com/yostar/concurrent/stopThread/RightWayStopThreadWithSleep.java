package com.yostar.concurrent.stopThread;

/**
 * 线程在睡眠时被中断
 */
public class RightWayStopThreadWithSleep {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                // 查找0-300内100的倍数，然后睡眠1秒
                int num = 0;
                while (!Thread.currentThread().isInterrupted() && num <= 300) {
                    if (num % 100 == 0) {
                        System.out.println(num + "是100的倍数");
                    }
                    num++;
                }
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("任务执行结束");
            }

        });
        thread.start();
        Thread.sleep(500);
        thread.interrupt();
    }
}
