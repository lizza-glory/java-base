package com.lizza.ThreadCommunication;

/**
 * 利用join方法进行线程之间的通信
 */
public class Join {

    public static void main(String[] args) throws Exception {

        Thread A = new Thread(() -> {
            try { Thread.sleep(5000); } catch (InterruptedException e) {}
            System.out.println("Thread A Is Finished");
        }, "A");
        Thread B = new Thread(() -> {
            try { Thread.sleep(2000); } catch (InterruptedException e) {}
            System.out.println("Thread B Is Finished");
        }, "B");
        A.start();
        B.start();
        A.join();
        B.join();
        System.out.println("Main Thread Is Finished");
    }
}
