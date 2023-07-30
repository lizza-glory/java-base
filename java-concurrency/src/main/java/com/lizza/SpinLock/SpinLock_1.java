package com.lizza.SpinLock;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 自旋锁：利用CAS操作，使得同一时刻，只能有一个线程获得锁，其他锁在不停的CAS操作
 * @author lt
 * @date 2019年5月22日
 * @version v1.0
 */
@SuppressWarnings("all")
public class SpinLock_1 {

	private AtomicReference<Thread> owner = new AtomicReference<>();
	
	public void lock(){
		Thread current = Thread.currentThread();
		while(true){
			//同一时刻，只能有一个线程获得锁，其他锁在不停的在此处进行CAS操作
			if(owner.compareAndSet(null, current)) break;
		}
		System.out.println(current.getName()+"获取到了锁！");
	}
	
	public void unlock(){
		Thread current = Thread.currentThread();
		while(true){
			//同一时刻，只能有一个线程释放锁，其他锁在不停的在此处进行CAS操作
			if(owner.compareAndSet(current, null)) break;
		}
		System.out.println("\t"+current.getName()+"释放了锁！");
	}
}
