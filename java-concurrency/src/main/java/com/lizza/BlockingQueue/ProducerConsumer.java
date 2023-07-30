package com.lizza.BlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 生产者-消费者模式（阻塞队列实现）
 * @author lt
 * @date 2019年5月29日
 * @version v1.0
 */
public class ProducerConsumer {

	public static void main(String[] args) {
		ArrayBlockingQueue<Object> abq = new ArrayBlockingQueue<>(10);
		new Producer(abq).start();
		new Consumer(abq).start();
	}
}

class Producer extends Thread {
	ArrayBlockingQueue<Object> abq;
	public Producer(ArrayBlockingQueue<Object> abq) {
		this.abq = abq;
	}
	@Override
	public void run() {
		for(int i=1; i<=10; i++){
			try {
				abq.put(i);
				System.out.println("生产者添加元素："+i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Consumer extends Thread {
	ArrayBlockingQueue<Object> abq;
	public Consumer(ArrayBlockingQueue<Object> abq) {
		this.abq = abq;
	}
	@Override
	public void run() {
		Object take = null;
		while(true){
			try {
				take = abq.take();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("\t消费者消费元素："+take);
		}
	}
}