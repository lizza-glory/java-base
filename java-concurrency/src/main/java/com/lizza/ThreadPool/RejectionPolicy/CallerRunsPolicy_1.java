package com.lizza.ThreadPool.RejectionPolicy;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Desc: 如果添加失败，则主线程会调用宿主线程自身的execute()去执行
 * @author: lizza1643@gmail.com
 * @date: 2019-10-10
 */
public class CallerRunsPolicy_1 {

    static BlockingQueue<String> msgQueue = new LinkedBlockingQueue<>();
    static ThreadPoolExecutor executor = new ThreadPoolExecutor(
            2,
            4,
            5,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(),
            new ThreadPoolExecutor.CallerRunsPolicy());

    public static void main(String[] args) throws InterruptedException {
        Monitor.monitoring();
        Producer.product();
        while (true) {
            String e = msgQueue.take();
            executor.execute(() -> {
                try {
                    Consumer.consume(e);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            });
        }
    }

    static class Consumer {
        static void consume(String e) throws InterruptedException {
            Thread.sleep(2000);
            System.out.println("["+Thread.currentThread().getName()+"]consume: "+e);
        }
    }

    static class Producer {
        static void product(){
            new Thread(() -> {
//                int i = 0;
//                while (true){
//                    msgQueue.add("No."+i++);
//                }
                for (int i = 0; i < 50; i++) {
                    msgQueue.add("No."+i);
                }
                System.out.println("["+Thread.currentThread().getName()+"]msgQueue: "+msgQueue);
            }).start();
        }
    }

    static class Monitor {
        static void monitoring(){
            new Thread(() -> {
                while (true){
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("["+Thread.currentThread().getName()+"]thread pool status info: " +
                            "[QueueSize="+executor.getQueue().size()+", " +
                            "ActiveCount="+executor.getActiveCount()+", " +
                            "CompletedTaskCount="+executor.getCompletedTaskCount()+", " +
                            "TaskCount="+executor.getTaskCount()+"]");
                    System.out.println("["+Thread.currentThread().getName()+"]msgQueue: "+msgQueue);

                }
            }).start();

        }
    }
}
