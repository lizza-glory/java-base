package com.lizza.MSC;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * MCS锁：
 * 1.
 * @author lt
 * @date 2019年5月23日
 * @version v1.0
 */
public class MCSLock {

	static class Node {
		String name = Thread.currentThread().getName();
		volatile Node next;
		volatile boolean isBlock = true;
		@Override
		public String toString() {
			String _name = next==null?"null":next.name;
			return "Node [name=" + name + ", next=" + _name + ", isBlock=" + isBlock + "]";
		}
	}
	volatile Node prev;
	private Node current;
	private AtomicReferenceFieldUpdater<MCSLock, Node> updater = AtomicReferenceFieldUpdater.newUpdater(MCSLock.class, Node.class, "prev");
	
	public void lock(){
		//1.为每一个线程创建一个Node
		Node node = new Node();
		//2.获取线程前任节点
		Node predecessor = updater.getAndSet(this, node);
		//3.如果前任节点为null，说明锁无人使用，isBlock置为false
		System.out.println("1.predecessor："+predecessor+"，node："+node);
		if(predecessor!=null){
			predecessor.next = node;
			System.out.println("\t2.predecessor："+predecessor+"，node："+node);
			while(node.isBlock);
		} else {
			System.out.println("\t\t3.predecessor："+predecessor+"，node："+node);
			node.isBlock = false;
		}
		//设置current（当前线程）
		if(!node.isBlock) current = node;
		//System.out.println(Thread.currentThread().getName()+"获取到了锁！");
	}
	public void unlock(){
//		System.out.println(current);
		if(current.next!=null){
			current.next.isBlock = false;
		}
	}
}
