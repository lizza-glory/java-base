package com.lizza.SpinLock;

/**
 * 自旋锁-测试
 * @author lt
 * @date 2019年5月22日
 * @version v1.0
 */
@SuppressWarnings("all")
public class SpinLock_4 {

	public void print(){
		SpinLock_3.lock();
		System.out.println("\t"+Thread.currentThread().getName()+"打印中...");
		try {
			Thread.currentThread().sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("\t"+Thread.currentThread().getName()+"打印完毕！");
		SpinLock_3.unlock();
	}
	
	public static void main(String[] args) {
		SpinLock_4 obj = new SpinLock_4();
		for(int i=0; i<5; i++){
			new Thread(new Runnable() {
				@Override
				public void run() {
					obj.print();
				}
			}, "线程"+i).start();;
		}
	}
}
