package com.learning.concurrency.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class Sample {

    public static int compute(int number){
        System.out.println("number "+number+", "+Thread.currentThread());
        if(number ==1)
            return  1;
        else {
            int part1 = number>>1;
            int part2 = number>>1;
            ForkJoinTask<Integer> taskPart1 = ForkJoinTask.adapt(()->compute(part1));
            ForkJoinTask<Integer> taskPart2 = ForkJoinTask.adapt(()->compute(part2));
            taskPart1.fork();
            taskPart2.fork();
            int result = taskPart1.join() + taskPart2.join();
            return  result;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ForkJoinPool pool = ForkJoinPool.commonPool();
        int result = pool.invoke(ForkJoinTask.adapt(()->compute(6)));
        pool.shutdown();
        pool.awaitTermination(10, TimeUnit.SECONDS);
        System.out.println(compute(16));
        Stream.of(1,2,3,4).forEach(Sample::printSomething);

        }

        public static <T> void printSomething(T value){
            System.out.println("Value: "+ value.toString());
        }
    }
