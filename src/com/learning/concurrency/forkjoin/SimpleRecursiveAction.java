package com.learning.concurrency.forkjoin;

import java.util.concurrent.RecursiveAction;

public class SimpleRecursiveAction extends RecursiveAction{

    /**
     * RecursiveTask<T> It will return a type
     * RecursiveAction -> Ti is a ask without any return value
     * ForkJoinPool generally creates thread as the number of cores.
     * fork()-> asynchronously executes
     */
    private int  simulatedWork;
    private int[] numbers;

    public SimpleRecursiveAction(int simulatedWork) {
        System.out.println(Thread.currentThread().getName());
        this.simulatedWork = simulatedWork;
    }

    @Override
    protected void compute() {
        final int length = numbers.length;
        if(length>100){
            System.out.println("Parallel execution and split task...."+length);
            /*for(int i =0;i<noOfThreads;i++) {
                actions =
                SimpleRecursiveAction action2 = new SimpleRecursiveAction(length >> 1);
            }
            action1.fork();
            action2.fork();*/
        } else {
            System.out.println("No neeed to work in parallel...."+ simulatedWork);
        }
    }
}
