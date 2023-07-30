package com.lizza.Thread;

/**
 * 守护线程
 * 1. 守护线程是一种服务型，支持型的线程，如Java虚拟机中的GC线程
 * 2. 守护线程随着主线程的消亡而消亡，即主线程结束了，守护线程也会结束
 * 3. 守护线程通过Thread中的setDaemon方法来设置，设置时机是线程启动之前
 * 4. 守护线程中的finally块中的代码不一定会执行
 */
public class Thread_05 {

    public static void main(String[] args){
    	Thread thread = new Thread(() -> {
    	    try {
                System.out.println("Thread " + Thread.currentThread().getName() + " Is Running!");
    	    } finally {
                System.out.println("Finally Block!");
    	    }
        });
    	thread.setDaemon(true);
    	thread.start();
    }
}
