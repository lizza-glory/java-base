package com.lizza.Sync;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2022-02-17
 */
public class Synchronized {

    public static void main(String[] args){
        synchronized (Synchronized.class) {
            System.out.println("同步代码执行");
        }
    }
}
