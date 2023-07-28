package com.lizza.ParallelStream;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2021-06-28
 */
public class ParallelStream_1 {

    public static void main(String[] args){
        List<CompletableFuture<Integer>> futureList = Lists.newArrayList();
        for (int i = 0; i < 10; i++) {
            futureList.add(
                CompletableFuture.supplyAsync(() -> {
                    System.out.println(Thread.currentThread().getName());
                    return 1;
                }, Executors.newFixedThreadPool(64, r -> new Thread(r, "parallel-thread"))));
        }
        futureList.forEach(item -> {
            try {
                System.out.println(item.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
