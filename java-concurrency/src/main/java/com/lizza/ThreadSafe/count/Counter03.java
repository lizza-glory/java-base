package com.lizza.ThreadSafe.count;

/**
 * 
 * @author lt
 * @date 2019年5月7日
 * @version v1.0
 */
public class Counter03 {

	public static int count = 0;
	
	private void add(){
		synchronized(this){
			Counter03.count++;
		}
	}
	
	public static void main(String[] args) throws Exception {
		Counter03 counter = new Counter03();
		for(int i=0; i<10; i++){
			new Thread(new Runnable() {
				@Override
				public void run() {
					for(int j=0; j<100; j++){
						counter.add();
					}
				}
			}).start();
		}
		Thread.sleep(500);
		System.out.println(Counter03.count);
	}
}
