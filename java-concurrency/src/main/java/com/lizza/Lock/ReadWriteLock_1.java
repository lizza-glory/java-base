package com.lizza.Lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 1. 多个线程同时读一个资源类没有任何问题, 所以为了满足并发量, 读取共享资源应该可以同时进行
 * 2. 但是如果有一个线程想去写共享资源来, 就不应该再有其它线程可以对该资源进行读或写
 * 3. 总结
 *      读-读能共存
 *      读-写不能共存
 *      写-写不能共存
 */
public class ReadWriteLock_1 {

    public static void main(String[] args){
        Cache cache = new Cache();
        for (int i = 1; i < 6; i++) {
            String temp = String.valueOf(i);
            new Thread(() -> {
                cache.put(temp, temp);
            }, String.valueOf(i)).start();
        }
        for (int i = 1; i < 6; i++) {
            String temp = String.valueOf(i);
            new Thread(() -> {
                cache.get(temp);
            }, String.valueOf(i)).start();
        }
    }
}

class Cache {
    private Map<String, Object> map = new HashMap<>();
    private ReadWriteLock lock = new ReentrantReadWriteLock();

    public void put(String key, Object object) {
        lock.writeLock().lock();
        try {
            System.out.println("> " + Thread.currentThread().getName() + " 开始写入");
            map.put(key, object);
            System.out.println("> " + Thread.currentThread().getName() + " 写入完成");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }
    }

    public Object get(String key) {
        lock.readLock().lock();
        try {
            System.out.println("< " + Thread.currentThread().getName() + " 开始读取");
            Object result = map.get(key);
            System.out.println("< " + Thread.currentThread().getName() + " 读取完成");
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }
        return null;
    }
}