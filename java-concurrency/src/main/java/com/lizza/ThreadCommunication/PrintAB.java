package com.lizza.ThreadCommunication;

import org.junit.Test;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2022-03-14
 */
public class PrintAB {

    String flag = "A";
    Object object = new Object();

    void printA() throws Exception {
        synchronized(object) {
            while (flag != "A") {
                object.wait();
            }
            System.out.println(flag);
            flag = "B";
            object.notifyAll();
        }
    }

    void printB() throws Exception {
        synchronized(object) {
            while (flag != "B") {
                object.wait();
            }
            System.out.println(flag);
            flag = "C";
            object.notifyAll();
        }
    }

    void printC() throws Exception {
        synchronized(object) {
            while (flag != "C") {
                object.wait();
            }
            System.out.println(flag);
            flag = "A";
            object.notifyAll();
        }
    }

    @Test
    public void test1() throws Exception {
        PrintAB ab = new PrintAB();
        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) ab.printA();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "t1").start();
        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) ab.printB();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "t2").start();
        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) ab.printC();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "t3").start();
    }

}
