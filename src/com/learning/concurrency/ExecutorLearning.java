package com.learning.concurrency;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ExecutorLearning {

    public static CompletableFuture<Integer> create(){
        return CompletableFuture.supplyAsync(() -> compute());
    }

    private static int compute() {
        return 2;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> integerList = List.of(1, 2, 3, 4, 6, 5, 7, 8, 9);
        integerList.parallelStream()
                .map(e->transform(e)).forEach(System.out::println);
        System.out.println("***********************");
        ExecutorService executorService = Executors.newFixedThreadPool(7);
        Callable<Integer> call1 = () -> transform(1);
        Callable<Integer> call2 = () -> transform(1);
        Callable<Integer> call3 = () -> transform(1);
        Callable<Integer> call4 = () -> transform(1);
        List<Callable<Integer>> callableList = List.of(call1, call2, call3, call4);
        executorService.invokeAll(callableList);
        executorService.shutdown();
    }

    private static int transform(Integer e) {
        System.out.println(Thread.currentThread());
        System.out.println(LocalDateTime.now());
        sleep(1000);
        return e * 1;
    }

    private static boolean sleep(long time) {
        try {
            Thread.sleep(time);
            return true;
        } catch (InterruptedException e) {
            return false;
        }
    }

    private static void println(Integer data) throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        Thread.sleep(2000);
        System.out.println(data);
    }
}
