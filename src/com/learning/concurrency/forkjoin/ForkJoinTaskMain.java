package com.learning.concurrency.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

public class ForkJoinTaskMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool pool = ForkJoinPool.commonPool();
        //invoke() method waits for the result. Can be used for tasks which needs wait
        //String result = (String) pool.invoke(task);
        //submit returns a result but execute doesn't return a result
        ForkJoinTask<String> task1 = pool.submit(ForkJoinTask.adapt(ForkJoinTaskMain::generateString));
        ForkJoinTask<String> task2 = pool.submit(ForkJoinTaskMain::generateString);
        ForkJoinTask<String> task3 = pool.submit(ForkJoinTaskMain::generateString);

        String result1 = pool.submit(task1).get();
        String result2 = pool.submit(task2).get();
        String result3 = pool.submit(task3).get();
        System.out.println("Done");
    }

    private static String generateString() {
        System.out.println("Thread: "+ Thread.currentThread());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
        }
        return "Hello";
    }
}
