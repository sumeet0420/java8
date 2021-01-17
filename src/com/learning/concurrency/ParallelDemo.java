package com.learning.concurrency;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.IntStream;

public class ParallelDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        int sum = IntStream.of(3, 1, 45, 6, 7, 12, 34, 5).sum();
        System.out.println("Total: "+sum);

        Instant start = Instant.now();
        int sum2 = IntStream.of(3, 1, 45, 6, 7, 12, 34, 5)
                .parallel()
                .map(ParallelDemo::doubleIt)
                .sum();
        Instant end = Instant.now();
        System.out.println(Duration.between(start, end).toMillis());


        CompletableFuture<Integer> completedFuture = CompletableFuture.completedFuture(43);
        CompletableFuture<Float> floatCompletableFuture = completedFuture.thenApply(Integer::floatValue);
        System.out.println(floatCompletableFuture.get());
    }

    private static int doubleIt(int number) {
        System.out.println(Thread.currentThread());
        sleep(100);
        return number*2;
    }

    private static boolean sleep(int ms) {
        try {
            Thread.sleep(ms);
            String word = null;

            return true;
        } catch (InterruptedException e) {
            return false;
        }
    }
}
