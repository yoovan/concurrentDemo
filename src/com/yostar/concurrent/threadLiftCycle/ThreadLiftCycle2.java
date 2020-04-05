package com.yostar.concurrent.threadLiftCycle;

/**
 * 演示状态 blocked、waiting、timed_waiting
 */
public class ThreadLiftCycle2 implements Runnable {
    @Override
    public void run() {
        try {
            syn();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private synchronized void syn() throws InterruptedException {
        Thread.sleep(1000);
        wait();
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadLiftCycle2 cycle1 = new ThreadLiftCycle2();
        Thread thread = new Thread(cycle1);
        Thread thread2 = new Thread(cycle1);
        thread.start();
        thread2.start();
        Thread.sleep(100);
        System.out.println(thread.getState()); // thread线程中在执行sleep方法 所以是timed_waiting
        // 在执行thread线程的synchronized方法，所以thread2线程被阻塞
        System.out.println(thread2.getState());
        Thread.sleep(1000);
        // thread线程结束睡眠后，又进入wait()方法等待，所以是waiting
        System.out.println(thread.getState());
    }
}
