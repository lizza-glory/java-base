package com.lizza.CAS;

/**
 * 验证多线程情况下由于重排序造成内存可见性的问题
 * @author lt
 * @date 2019年5月13日
 * @version v1.0
 */
public class Thread_1 {

	static int a = 0;
	static boolean flag = false;
	void write() throws InterruptedException{
		a = 1;
		flag = true;
	}
	void read() throws InterruptedException{
		if(flag){
			System.out.println("flag："+flag+"，a："+a);
		} else {
			System.out.println("flag："+flag+"，a："+a);
		}
	}
	
	public static void main(String[] args) throws Exception {
		final Thread_1 thread_1 = new Thread_1();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					thread_1.write();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "线程1");
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					thread_1.read();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "线程2");
		t1.start();
		t2.start();
		t1.join();
		t2.join();
	}
}
