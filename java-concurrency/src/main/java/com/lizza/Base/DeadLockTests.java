package com.lizza.Base;

import org.junit.Test;

/**
 * 死锁演示
 * 两个线程都持有对方线程所有需要的资源的锁
 *
 * jstack工具
 * jstack是java虚拟机自带的一种堆栈跟踪工具
 * jstack用于打印出给定的java进程ID或corefile或远程调试服务的Java堆栈信息
 * 如果是在64位机器上，需要指定选项"-J-d64"，Windows的jstack使用方式只支持以下的这种方式：jstack[-l]pid
 * 主要分为两个功能：
 * a．针对活着的进程做本地的或远程的线程dump；
 * b．针对core文件做线程dump。
 *
 * 下面使用“死锁”来查看Java堆栈信息
 */
public class DeadLockTests {

    @Test
    public void test1() throws Exception {
        Object a = new Object();
        Object b = new Object();

        Thread thread1 = new Thread(() -> {
            synchronized (a) {
                System.out.println(Thread.currentThread().getName() + " 获取到了 a 对象");
                try {
                    Thread.sleep(5000);
                } catch (Exception e) {
                }
                synchronized (b) {
                    System.out.println(Thread.currentThread().getName() + " 获取到了 b 对象");
                }
            }
        }, "thread-1");

        Thread thread2 = new Thread(() -> {
            synchronized(b) {
                System.out.println(Thread.currentThread().getName() + " 获取到了 b 对象");
                try { Thread.sleep(5000); } catch (Exception e) {}
                synchronized (a) {
                    System.out.println(Thread.currentThread().getName() + " 获取到了 a 对象");
                }
            }
        }, "thread-2");
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("main end");
    }
}
