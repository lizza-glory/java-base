package com.lizza.Base;

import org.junit.Test;

/**
 *
 */
public class WaitTests {

	/**
	 * wait 必须在持有了对象的锁之后才能调用, 否则会抛出 IllegalMonitorStateException
	 */
	@Test
	public void test1() throws InterruptedException {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("start...");
				try {
					this.wait(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("end...");
			}
		});
		thread.start();
		thread.join();
	}

	@Test
	public void test2() throws InterruptedException {
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (this) {
					System.out.println("start...");
					try {
						this.wait(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("end...");
				}
			}
		});
		thread.start();
		thread.join();
	}
}
