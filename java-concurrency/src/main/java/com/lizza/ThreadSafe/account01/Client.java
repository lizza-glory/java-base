package com.lizza.ThreadSafe.account01;

/**
 * 测试类测试两个人同时操作同一个账户(取同一个账户的钱)
 * @author lt
 * @date 2019年5月7日
 * @version v1.0
 */
public class Client {
	
	public static void main(String[] args) {
		Account account = new Account("0001", 1000);
		new DrawThread("甲", account, 800).start();
		new DrawThread("乙", account, 800).start();
	}
}
