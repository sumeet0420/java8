package com.learning.concurrency.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.TimeUnit;

public class ForkJoinMain {

    public static void main(String[] args) throws InterruptedException {
        ForkJoinPool pool = new ForkJoinPool(15); // ForkJoinPool.commonPool();
        System.out.println(pool);
        pool.execute(ForkJoinTask.adapt(()->task(90)));
        System.out.println("DONE....");
        sleep(1000);
        for (int i = 0; i < 20; i++) {
            final int index = i;
            pool.submit(()->task(index));
        }
        int count = 0;
        while(count++<10){
            System.out.println(pool);
            sleep(1000);
        }

        pool.awaitTermination(10, TimeUnit.SECONDS);
    }

    private static void task(int index) {
        System.out.println("task "+ index + " entering: "+ Thread.currentThread());
        sleep(3000);
        System.out.println("task "+ index + " exiting: "+ Thread.currentThread());
    }

    private static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
        }
    }
}
