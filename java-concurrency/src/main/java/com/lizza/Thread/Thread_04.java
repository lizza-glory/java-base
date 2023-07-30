package com.lizza.Thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 利用线程池进程创建线程
 */
public class Thread_04 {

    public static void main(String[] args){
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            System.out.println("Thread " + Thread.currentThread().getName() + " Is Running!");
        });
    }
}
