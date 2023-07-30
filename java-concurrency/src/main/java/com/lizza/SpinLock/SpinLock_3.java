package com.lizza.SpinLock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 自旋锁
 * @author lt
 * @date 2019年5月22日
 * @version v1.0
 */
@SuppressWarnings("all")
public class SpinLock_3 {

	private static AtomicReference<Thread> owner = new AtomicReference<>();
	
	public static void lock(){
		Thread current = Thread.currentThread();
		owner.compareAndSet(null, current);
		System.out.println(current.getName()+"获取到了锁！");
	}
	
	public static void unlock(){
		Thread current = Thread.currentThread();
		owner.compareAndSet(current, null);
		System.out.println("\t"+current.getName()+"释放了锁！");
	}
}
