package com.lizza.Lock.ResourceLock.service;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2021-07-05
 */
public class ServiceB {

    public Object getResult(String param) {
        try {
            Thread.sleep(100);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Invoke ServiceB, Param: " + param;
    }
}
