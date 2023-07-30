package com.lizza.ThreadPool.newCachedThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Desc: 可缓存的线程池；当线程池中有空闲线程时，会被回收；当任务较多时，会动态创建新的线程；线程
 * 数量的最大值依赖于操作系统可以创建的线程数
 * @author: lizza1643@gmail.com
 * @date: 2019-08-08
 */
public class NewCachedThreadPool {

    public static void main(String[] args){
        ExecutorService executorService = Executors.newCachedThreadPool();
    	for(int i=0; i<10; i++){
    	    Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"运行...");
                }
            });
    	    executorService.execute(thread);
        }
    	executorService.shutdown();
    }
}

