package com.lizza.SpinLock;

/**
 * 自旋锁-测试
 * @author lt
 * @date 2019年5月22日
 * @version v1.0
 */
@SuppressWarnings("all")
public class SpinLock_6 {

	private SpinLock_5 lock = new SpinLock_5();

	public void print(){
		lock.lock();
		System.out.println("\t"+Thread.currentThread().getName()+"打印中...");
		try {
			Thread.currentThread().sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("\t"+Thread.currentThread().getName()+"打印完毕！");
		lock.unlock();
	}
	
	public static void main(String[] args) {
		SpinLock_6 obj = new SpinLock_6();
		for(int i=0; i<3; i++){
			new Thread(new Runnable() {
				@Override
				public void run() {
					obj.print();
				}
			}, "线程"+i).start();;
		}
	}
}
