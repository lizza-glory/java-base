package com.lizza.ParallelCompute;

import com.google.common.base.Stopwatch;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class ParallelComputeTests {

    ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static String calculate(int i) {
        try {
            TimeUnit.SECONDS.sleep(i);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Thread.currentThread().getName() + ", result: " + i;
    }

    @Test
    public void test1() throws Exception {
        Stopwatch stopwatch = Stopwatch.createStarted();
        List<CompletableFuture<String>> futureList = Lists.newArrayList();
        IntStream.rangeClosed(1, 5).forEach(i -> {
            futureList.add(CompletableFuture.supplyAsync(() -> calculate(i), executorService));
        });
        System.out.println(12345);
        for (CompletableFuture<String> future : futureList) {
            System.out.println(Thread.currentThread().getName() + ":" + future.get());
        }
        System.out.println("cost: " + stopwatch.elapsed(TimeUnit.MILLISECONDS));
    }

    @Test
    public void test2() throws Exception {
        Stopwatch stopwatch = Stopwatch.createStarted();
        CompletableFuture[] futures = new CompletableFuture[5];
        IntStream.rangeClosed(1, 5).forEach(i -> {
            futures[i - 1] = CompletableFuture.supplyAsync(() -> calculate(i), executorService);
        });

        CompletableFuture.allOf(futures);
        System.out.println(12345);
        for (CompletableFuture<String> future : futures) {
            System.out.println(future.get());
        }
        System.out.println("cost: " + stopwatch.elapsed(TimeUnit.MILLISECONDS));
    }

    @Test
    public void test3() throws Exception {
    }
}
