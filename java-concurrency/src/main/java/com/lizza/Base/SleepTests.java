package com.lizza.Base;

/**
 * sleep
 * 1. 将当前线程阻塞指定时长, 时间到时, 线程处于就绪状态, 并不是马上进入运行状态
 * 2. 在同步块中执行sleep方法时, 线程阻塞期间, 不会释放对象锁, 其他线程无法访问该对象
 */
public class SleepTests {

    public static void main(String[] args){
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
                if (i == 3) {
                    try {
                        Thread.currentThread().sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        System.out.println(Thread.currentThread().getName() + " run");
    }
}
