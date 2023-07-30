package com.lizza.ParallelCompute.allOf_2;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2021-07-27
 */
public class Computer {

    public static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(10,
            r -> new Thread("computer_executor"));

    public static void main(String[] args){
        List<CompletableFuture<String>> futureList = Lists.newArrayList();
        for (int i = 1; i <= 3; i++) {
            int index = i;
            futureList.add(CompletableFuture.supplyAsync(() -> {
                try {
                    String name = Thread.currentThread().getName();
                    System.out.println(name);
                    int time = index * 100;
//                    Thread.sleep(time);
                    String msg = "Thread: " + name + " cost: " + time;
                    System.out.println(msg);
                    return msg;
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }, EXECUTOR_SERVICE));
        }
        try {
            List<String> list = allOf(futureList).get();
            System.out.println("result: " + list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static <T> CompletableFuture<List<T>> allOf(List<CompletableFuture<T>> futuresList) {
        CompletableFuture<Void> allFuturesResult =
                CompletableFuture.allOf(futuresList.toArray(new CompletableFuture[futuresList.size()]));
        return allFuturesResult.thenApply(v ->
                futuresList.stream().
                        map(CompletableFuture::join).
                        collect(Collectors.toList())
        );
    }
}
