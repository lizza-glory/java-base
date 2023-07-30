package com.lizza.CLH;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * CLH 队列
 */
public class CLHLock {

	static class Node{
		String name = Thread.currentThread().getName();
		volatile boolean isBlock = true;
		@Override
		public String toString() {
			return "Node [name=" + name + ", isBlock=" + isBlock + "]";
		}
	}
	
	volatile Node current;
	volatile Node tail;
	private AtomicReferenceFieldUpdater<CLHLock, Node> updater = AtomicReferenceFieldUpdater.newUpdater(CLHLock.class, Node.class, "tail");
	
	@SuppressWarnings("static-access")
	public void lock(){
		//1.为每一个线程创建一个Node
		Node node = new Node();
		//2.获取线程前任节点
		Node predecessor = updater.getAndSet(this, node);
		System.out.println("1.predecessor："+predecessor+"，node："+node);
		if(predecessor!=null){
			System.out.println("\t2.predecessor："+predecessor+"，node："+node);
			while(predecessor.isBlock){
				try {
					Thread.currentThread().sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("\t\t\t"+Thread.currentThread().getName());
			}
		} else {
			node.isBlock = false;
		}
		if(!node.isBlock){
			current = node;
		}
		System.out.println("\t\t3.predecessor："+predecessor+"，node："+current);
		//System.out.println(Thread.currentThread().getName()+"获取到了锁！");
	}
	public void unlock(){
//		if(!updater.compareAndSet(this, current, null)){
////			System.out.println("2."+current);
//			current.isBlock = false;
//		}
	}
}
