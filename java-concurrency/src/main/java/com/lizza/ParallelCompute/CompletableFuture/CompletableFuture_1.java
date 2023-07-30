package com.lizza.ParallelCompute.CompletableFuture;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2021-08-01
 */
public class CompletableFuture_1 {

    static ExecutorService executorService = Executors.newCachedThreadPool();

    public static void main(String[] args){
        List<CompletableFuture<Integer>> futureList = Lists.newArrayList();
        for (int i = 0; i < 100; i++) {
            int count = i;
            futureList.add(CompletableFuture.supplyAsync(() -> count, executorService));
        }
    }
}
