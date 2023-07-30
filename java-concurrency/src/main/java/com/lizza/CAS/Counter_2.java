package com.lizza.CAS;

import java.util.ArrayList;
import java.util.List;

/**
 * 验证volatile不能满足复杂操作的原子性：i++
 * @author lt
 * @date 2019年5月11日
 * @version v1.0
 */
public class Counter_2 {

	private volatile int m = 0;
	public void count(){
		m++;
	}
	public static void main(String[] args) throws Exception {
		Counter_2 c = new Counter_2();
		List<Thread> ts = new ArrayList<>();
		for(int i=0; i<1000; i++){
			Thread t = new Thread(new Runnable() {
				@Override
				public void run() {
					c.count();
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
	}
}
