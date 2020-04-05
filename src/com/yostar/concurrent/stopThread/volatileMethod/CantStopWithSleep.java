package com.yostar.concurrent.stopThread.volatileMethod;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class CantStopWithSleep {

    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<Integer> storage = new ArrayBlockingQueue<>(10);
        Producer producer = new Producer(storage);
        Thread thread = new Thread(producer);
        thread.start();
        Thread.sleep(1000);
        Consumer consumer = new Consumer(storage);
        while (consumer.isNeed()) {
            System.out.println(storage.take() + "被消费了");
            Thread.sleep(100);
        }
        producer.setCancel(true);
        System.out.println(producer.isCancel());
    }

}

class Producer implements Runnable {

    private volatile boolean cancel = false;

    private BlockingQueue storage;

    public Producer(BlockingQueue blockingQueue) {
        this.storage = blockingQueue;
    }

    @Override
    public void run() {
        int num = 0;
        try {
            while (num <= 10000 && !cancel) {
                if (num % 100 == 0) {
                    System.out.println(num + "是100的倍数，保存到仓库中");
                    storage.put(num);
//                    Thread.sleep(1);  // 程序会陷入等待

                }
                num++;
//                Thread.sleep(1); // 可以被正常终止，注释后程序陷入等待
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("生产者停止运行");
        }
    }

    public boolean isCancel() {
        return cancel;
    }

    public void setCancel(boolean cancel) {
        this.cancel = cancel;
    }
}

class Consumer {

    private BlockingQueue storage;

    public Consumer(BlockingQueue storage) {
        this.storage = storage;
    }

    public boolean isNeed() {
        if (Math.random() > 0.95) {
            return false;
        }
        return true;
    }
}
