package com.yostar.concurrent.stopThread.volatileMethod;

public class CanStopWithNormal {

    private static volatile boolean cancel = false;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            int num = 0;
            while (num <= 10000 && !cancel) {
                if (num % 100 == 0) {
                    System.out.println(num + "是100的倍数");
                }
                num++;
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        Thread.sleep(3000);
        cancel = true;
    }
}
