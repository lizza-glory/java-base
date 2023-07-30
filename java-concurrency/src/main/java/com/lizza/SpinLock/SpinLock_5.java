package com.lizza.SpinLock;

/**
 * 自旋锁
 * @author lt
 * @date 2019年5月22日
 * @version v1.0
 */
@SuppressWarnings("all")
public class SpinLock_5 {

	private Thread owner = null;
	
	public void lock(){
		owner = Thread.currentThread();
		while(true){
			if(owner==Thread.currentThread()) break;
		}
		System.out.println(owner.getName()+"获取到了锁！");
	}
	
	public void unlock(){
		owner = null;
		while(true){
			if(owner==null){
				break;
			} else {
				System.out.println("\t"+owner.getName()+"释放了锁！");
			}
		}
	}
}
