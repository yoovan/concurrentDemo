package com.yostar.concurrent.createThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableStyle implements Callable<String> {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> stringFutureTask = new FutureTask<>(new CallableStyle());
        new Thread(stringFutureTask).start();
        String result = stringFutureTask.get();
        System.out.println(result);
    }

    @Override
    public String call() throws Exception {
        return Thread.currentThread().getName();
    }
}
