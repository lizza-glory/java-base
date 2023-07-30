package com.lizza.ThreadPool.RejectionPolicy;

import java.util.concurrent.*;

/**
 * 自定义拒绝策略
 */
public class CustomizedPolicy_1 {

    static BlockingQueue<String> msgQueue = new LinkedBlockingQueue<>();
    static ThreadPoolExecutor executor = new ThreadPoolExecutor(
            2,
            4,
            5,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(),
            new RejectedExecutionHandler() {
                @Override
                public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                    if(!executor.isShutdown()){
                        try {
                            executor.getQueue().put(r);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });

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
            System.out.println("create task ...");
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
                        Thread.sleep(1000);
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
