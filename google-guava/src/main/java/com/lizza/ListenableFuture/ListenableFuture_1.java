package com.lizza.ListenableFuture;

import com.google.common.util.concurrent.*;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.concurrent.Executors;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2021-08-07
 */
public class ListenableFuture_1 {

    public static void main(String[] args){
        ListeningExecutorService executorService = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(10));
        ListenableFuture<Integer> future = executorService.submit(
                ListenableFuture_1::task1);
        Futures.addCallback(future, new FutureCallback<Integer>() {
            @Override
            public void onSuccess(@Nullable Integer result) {
                System.out.println("task 1 success: " + result);
            }

            @Override
            public void onFailure(Throwable t) {
                System.out.println("task 1 failure");
            }
        }, executorService);
        executorService.shutdown();
    }

    static int task1() {
        handle(100);
        return 1;
    }

    static void handle(int cost) {
        try {
            Thread.sleep(cost);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
