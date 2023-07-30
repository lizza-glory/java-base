package com.lizza.ThreadPool.newFixedThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 固定数量线程池
 * @author: lizza1643@gmail.com
 * @date: 2019-08-08
 */
public class NewFixedThreadPool {

    public static void main(String[] args){
        ExecutorService executorService = Executors.newFixedThreadPool(9);
        for(int i=0; i<10; i++){
            Thread thread = new Thread(() ->
                    System.out.println(Thread.currentThread().getName()+"运行..."));
            executorService.execute(thread);
        }
        executorService.shutdown();
    }
}

