package com.lizza.ThreadPool.Monitor;

import java.util.concurrent.*;

/**
 * @Desc: 线程池监控
 * @author: lizza1643@gmail.com
 * @date: 2019-09-25
 */
public class Base_1 {

    public static void main(String[] args){
        LinkedBlockingQueue queue = new LinkedBlockingQueue();
        for (int i = 0; i < 100; i++) {
            queue.add("No."+i);
        }
        System.out.println(queue);
        ThreadPoolExecutorWrap executor = new ThreadPoolExecutorWrap(
                2, 4, 1,
                TimeUnit.MINUTES, new SynchronousQueue(true),
                new ThreadPoolExecutor.CallerRunsPolicy());
        while (true){
            for (int i = 0; i < queue.size(); i++) {
                executor.execute(() -> {
                    System.out.println("["+Thread.currentThread().getName()+"]"+queue.poll());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }
        }
    }

    static class ThreadPoolExecutorWrap extends ThreadPoolExecutor{

        public ThreadPoolExecutorWrap(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
            super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
        }

        public ThreadPoolExecutorWrap(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
            super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory);
        }

        public ThreadPoolExecutorWrap(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, RejectedExecutionHandler handler) {
            super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, handler);
        }

        public ThreadPoolExecutorWrap(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
            super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
        }

        @Override
        public void execute(Runnable command) {
            monitor();
            super.execute(command);
        }

        void monitor(){
            System.out.println("thread pool status info: " +
                            "[QueueSize="+this.getQueue().size()+", " +
                            "ActiveCount="+this.getActiveCount()+", " +
                            "CompletedTaskCount="+this.getCompletedTaskCount()+", " +
                            "TaskCount="+this.getTaskCount()+"]");
        }
    }
}
