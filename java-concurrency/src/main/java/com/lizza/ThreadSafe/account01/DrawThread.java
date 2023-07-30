package com.lizza.ThreadSafe.account01;

/**
 * 取款操作的线程,继承Thread类
 * @author lt
 * @date 2019年5月7日
 * @version v1.0
 */
public class DrawThread extends Thread{

	private Account account;
	private double drawAmount;
	public DrawThread(String name, Account account, double drawAmount){
		super(name);
		this.account = account;
		this.drawAmount = drawAmount;
	}
	public void run(){
		account.draw(drawAmount);
	}
}

