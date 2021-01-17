package com.learning.concurrency.executor;

import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Sample {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(4);
//        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            service.execute(()->{
                System.out.printf("Hello from %s%n",Thread.currentThread().getName());
                System.out.println(LocalDateTime.now());
            });
        }
        service.shutdown();
    }
}
