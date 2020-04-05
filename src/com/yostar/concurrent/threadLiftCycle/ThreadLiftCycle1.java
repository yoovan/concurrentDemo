package com.yostar.concurrent.threadLiftCycle;

/**
 * 演示状态 new runnable terminated
 */
public class ThreadLiftCycle1 implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadLiftCycle1 cycle1 = new ThreadLiftCycle1();
        Thread thread = new Thread(cycle1);
        System.out.println(thread.getState());
        thread.start();
        System.out.println(thread.getState());
        thread.join();
        System.out.println(thread.getState());
        Thread.sleep(1100);
        System.out.println(thread.getState());
    }
}
