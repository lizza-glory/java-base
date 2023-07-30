package com.lizza.CAS;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 1.验证Java利用循环CAS验证操作完成原子操作
 * @author lt
 * @date 2019年5月11日
 * @version v1.0
 */
public class Counter_1 {

	private int m = 0;
	private AtomicInteger n = new AtomicInteger();
	//非线程安全的计数方法
	public void count(){
		m++;
	}
	//利用JUC的相关类实现线程安全的计数器（CAS）
	public void safeCount(){
		//循环进行CAS操作，直至成功为止
		while(true){
			int i = n.get();
			//如果当前值==期望值，则以原子方式将值设置为给定的更新值。相当于i=++i
			boolean flag = n.compareAndSet(i, ++i);
			//如果设置成功，则跳出循环，否则继续设置
			if(flag) break;
		}
	}
	public static void main(String[] args) throws Exception {
		Counter_1 c = new Counter_1();
		List<Thread> ts = new ArrayList<>();
		for(int i=0; i<1000; i++){
			Thread t = new Thread(new Runnable() {
				@Override
				public void run() {
					c.count();
					c.safeCount();
				}
			}, "线程"+i);
			ts.add(t);
		}
		for(Thread t : ts){
			t.start();
		}
		//等待当前线程执行完毕
		for(Thread t : ts){
			t.join();
		}
		System.out.println(c.m);
		System.out.println(c.n);
	}
}
