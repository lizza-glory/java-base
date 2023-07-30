package com.lizza.FairLock;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 公平锁
 * @author lt
 * @date 2019年5月22日
 * @version v1.0
 */
public class FairLock_1 {

	//服务序号：记录当前线程的线程序号
	private AtomicInteger s_num = new AtomicInteger();
	//线程序号：每一个线程都会“持有”一个号码，当自己的号码和服务号码一致时，结束自旋，进行共享资源的操作
	private AtomicInteger t_num = new AtomicInteger();
	
	public void lock(){
		//所有线程蜂拥而至，争抢线程序号，拿到No.1的第一个执行，执行完成后调用unlock方法，将s_num加一，No.2执行
		int num = t_num.getAndIncrement();
		while(s_num.get()!=num);
		System.out.println(Thread.currentThread().getName()+"获取到了锁！");
	}
	
	public void unlock(){
		s_num.getAndIncrement();
	}
}
