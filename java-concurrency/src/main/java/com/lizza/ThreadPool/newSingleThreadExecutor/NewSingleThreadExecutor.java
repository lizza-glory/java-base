package com.lizza.ThreadPool.newSingleThreadExecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 单一线程线程池，顺序执行所有任务，若有任务抛出异常导致线程结束，会有新的线程来代替
 * @author: lizza
 * @date: 2019-08-08 15:15
 */
public class NewSingleThreadExecutor {

    public static void main(String[] args){
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Worker worker = new Worker();
        executorService.execute(worker);
        executorService.shutdown();
    }
}

class Worker implements Runnable {

    @Override
    public void run() {
        int i = 1;
        while (true){
            //如果工作线程挂了，会有新的线程去替换
            if(i%5==0){
                throw new NullPointerException();
            }
            System.out.println(Thread.currentThread().getName()+"运行...");
            i++;
        }
    }
}
