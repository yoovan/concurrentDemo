package com.yostar.concurrent.stopThread;

/**
 * 普通情况下正确停止子线程
 */
public class RightWayStopThreadWithNormal {

    public static void main(String[] args) throws InterruptedException {
        // 从0至最大整数值的一半找出10000的倍数
        Thread thread = new Thread(() -> {
            int num = 0;
            // 需要判断当前线程是否被终止
            while (!Thread.currentThread().isInterrupted() && num <= Integer.MAX_VALUE / 2) {
                if (num % 1000 == 0) {
                    System.out.println(num + "是10000的倍数");
                }
                num++;
            }
            System.out.println("任务执行结束");
        });
        thread.start();
        Thread.sleep(2000);
        thread.interrupt(); // 需要在线程中和isInterrupt()配合使用才能生效
    }
}
