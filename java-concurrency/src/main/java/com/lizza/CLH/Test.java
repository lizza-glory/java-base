package com.lizza.CLH;

/**
 * MCS锁-测试
 * @author lt
 * @date 2019年5月22日
 * @version v1.0
 */
public class Test {

	private CLHLock lock = new CLHLock();
	@SuppressWarnings("static-access")
	public void print(){
		lock.lock();
//		System.out.println("\t"+Thread.currentThread().getName()+"打印中...");
		try {
			Thread.currentThread().sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
//		System.out.println("\t"+Thread.currentThread().getName()+"打印完毕！");
		lock.unlock();
	}
	
	public static void main(String[] args) {
		Test obj = new Test();
		for(int i=0; i<5; i++){
			new Thread(new Runnable() {
				@Override
				public void run() {
					obj.print();
				}
			}, "线程"+i).start();
		}
	}
}
