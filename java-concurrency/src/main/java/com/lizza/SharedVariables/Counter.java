package com.lizza.SharedVariables;

import org.junit.Test;

/**
 * Copyright (C) 2015 - 2019 MICROSCENE Inc., All Rights Reserved.
 * 计数器
 * @author: lizza@vizen.cn
 * @date: 2019-08-07
 */
public class Counter {

    static int n = 0;

    void count() {
        for(int i=1; i<=10; i++){
            n += i;
        }
        System.out.println("Thread Name: "+Thread.currentThread().getName()+", n: "+n);
    }

    @Test
    public void test1(){
        Counter counter = new Counter();
        counter.count();
    }

    @Test
    public void test2(){
        Runnable r = new Runnable() {
            public void run() {
                Counter counter = new Counter();
                counter.count();
            }
        };
        for(int i=0; i<10; i++){
            new Thread(r).start();
        }
    }

}
