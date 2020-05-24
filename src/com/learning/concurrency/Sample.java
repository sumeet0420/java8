package com.learning.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Sample {
    public static void main(String[] args) {
        Thread thread1 = new Thread(()-> System.out.println(Thread.currentThread().getName()+
                "Thread 1 running"));
        thread1.start();
        System.out.println(Thread.currentThread().getName()+"Main Thread running...");
        ExecutorService threads = Executors.newFixedThreadPool(100);
        threads.submit(()-> System.out.println(Thread.currentThread().getName()+"Executor thread 1"));
        threads.shutdown();
    }
}
