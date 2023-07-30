package com.lizza.Lock.ResourceLock.service;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2021-07-05
 */
public class ServiceA {

    public Object getResult(String param) {
        try {
            System.out.println("Invoke ServiceA, Param: " + param);
            Thread.sleep(600);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Invoke ServiceA, Param: " + param;
    }
}
