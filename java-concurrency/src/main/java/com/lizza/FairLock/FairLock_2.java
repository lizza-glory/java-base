package com.lizza.FairLock;

/**
 * 公平锁-测试
 * @author lt
 * @date 2019年5月22日
 * @version v1.0
 */
@SuppressWarnings("all")
public class FairLock_2 {

	private FairLock_1 lock = new FairLock_1();
	public void print(){
		lock.lock();
		System.out.println("\t"+Thread.currentThread().getName()+"打印中...");
		try {
			Thread.currentThread().sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("\t"+Thread.currentThread().getName()+"打印完毕！");
		lock.unlock();
	}
	
	public static void main(String[] args) {
		FairLock_2 obj = new FairLock_2();
		for(int i=0; i<20; i++){
			new Thread(new Runnable() {
				@Override
				public void run() {
					obj.print();
				}
			}, "线程"+i).start();;
		}
	}
}
