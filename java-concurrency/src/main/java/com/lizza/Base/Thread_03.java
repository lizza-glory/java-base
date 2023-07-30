package com.lizza.Base;

/**
 * yield
 */
public class Thread_03 {

    public static void main(String[] args){
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
            if (i == 13) {
                Thread.currentThread().yield();
                new Thread(() -> {
                    for (int j = 0; j < 5; j++) System.out.println(Thread.currentThread().getName() + " : " + j);
                }).start();
            }
        }
    }
}
