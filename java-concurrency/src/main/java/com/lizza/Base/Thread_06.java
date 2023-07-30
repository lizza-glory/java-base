package com.lizza.Base;

/**
 * notify()方法：唤醒阻塞的线程
 * @author lt
 * @date 2019年5月9日
 * @version v1.0
 */
public class Thread_06 {

	public synchronized void print(){
		System.out.println(Thread.currentThread().getName()+"：start...");
		try {
			this.wait(0);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"：end...");
		
	}
	
	public static void main(String[] args) throws Exception {
		Thread_06 o = new Thread_06();
		for(int i=0; i<5; i++){
			new Thread(new Runnable() {
				@Override
				public void run() {
					o.print();
				}
			}, "线程"+i).start();
		}
		synchronized (o) {
			o.notify();
		}
		//为何要sleep(3000)?
		Thread.sleep(3000);
		synchronized (o) {
			o.notifyAll();
		}
	}
}
