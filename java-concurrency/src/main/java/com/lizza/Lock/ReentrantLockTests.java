package com.lizza.Lock;

import org.junit.Test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import static java.lang.Thread.sleep;

/**
 * ReentrantLock
 */
public class ReentrantLockTests {

	/**
	 * 独占锁, 非公平锁
	 */
	@Test
	public void test1() throws Exception {
		Lock lock = new ReentrantLock();
		for (int i = 0; i < 10; i++) {
			new Thread(() -> {
				lock.lock();
				try {
					System.out.println(Thread.currentThread().getName() + " lock success!");
					try {
					    sleep(50);
					} catch (InterruptedException e) {
					    e.printStackTrace();
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					lock.unlock();
				}
			}, "thread-" + i).start();
		}
    }

	/**
	 * 独占锁, 公平锁
	 */
	@Test
	public void test2() throws Exception {
		Lock lock = new ReentrantLock(true);
        lock.lock();
    	try {
    	    System.out.println("ReentrantLock");
    	} catch (Exception e) {
    	    e.printStackTrace();
    	} finally {
    	    lock.unlock();
    	}
    }

	/**
	 * 共享锁, 非公平锁
	 */
	@Test
	public void test3() throws Exception {
		ReentrantReadWriteLock.ReadLock lock = new ReentrantReadWriteLock().readLock();
        lock.lock();
    	try {
    	    System.out.println("ReentrantLock");
    	} catch (Exception e) {
    	    e.printStackTrace();
    	} finally {
    	    lock.unlock();
    	}
    }

	/**
	 * 共享锁, 公平锁
	 */
	@Test
	public void test4() throws Exception {
		Lock lock = new ReentrantLock(true);
        lock.lock();
    	try {
    	    System.out.println("ReentrantLock");
    	} catch (Exception e) {
    	    e.printStackTrace();
    	} finally {
    	    lock.unlock();
    	}
    }
}
