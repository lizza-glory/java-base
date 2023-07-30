package com.lizza.Base;

/**
 * notify()方法：唤醒阻塞的线程
 * @author lt
 * @date 2019年5月9日
 * @version v1.0
 */
public class Thread_07 {

	public void print(){
		System.out.println(Thread.currentThread().getName()+"：start...");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"：end...");
		
	}
	
	public static void main(String[] args) throws Exception {
		Thread_07 o = new Thread_07();
		for(int i=0; i<5; i++){
			new Thread(new Runnable() {
				@Override
				public void run() {
					o.print();
				}
			}, "线程"+i).start();
		}
	}
}
