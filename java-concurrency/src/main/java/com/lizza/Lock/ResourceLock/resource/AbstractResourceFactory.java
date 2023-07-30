package com.lizza.Lock.ResourceLock.resource;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2021-07-05
 */
public abstract class AbstractResourceFactory {

    abstract Object fetch(String param);

    public static void main(String[] args){
        ResourceA resourceA = new ResourceA();
        ResourceB resourceB = new ResourceB();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                resourceB.fetch("resource B");
                resourceA.fetch("resource A");
            }, "name-" + i).start();
        }
    }
}
