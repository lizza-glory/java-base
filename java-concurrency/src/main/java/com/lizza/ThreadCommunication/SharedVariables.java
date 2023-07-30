package com.lizza.ThreadCommunication;

/**
 * 线程间通过共享变量进行通信
 */
public class SharedVariables {

    private volatile static boolean flag = true;

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            flag = false;
        }, "T").start();
        while (flag) {}
        System.out.println("Main Thread Is Finished");
    }
}
