package com.lizza.ThreadSafe.account01;

/**
 * 账户类,主要记录账户余额,以及提供取款方法
 * @author lt
 * @date 2019年5月7日
 * @version v1.0
 */
public class Account {
	private String accountNo;
	private double balance;
	public Account(String accountNo, double balance){
		this.accountNo = accountNo;
		this.balance = balance;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	//账户余额不允许随便修改,故只提供get方法
	public double getBalance() {
		return balance;
	}
	public void draw(double drawAmount){
		//取钱数不能超过余额数
		if(balance>=drawAmount){
			System.out.println(Thread.currentThread().getName()+"取钱成功！吐出钞票："+drawAmount);
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//修改余额
			balance -= drawAmount;
			System.out.println("\t余额为："+balance);
		} else {
			System.out.println("余额不足！取钱失败！");
		}
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((accountNo == null) ? 0 : accountNo.hashCode());
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (accountNo == null) {
			if (other.accountNo != null)
				return false;
		} else if (!accountNo.equals(other.accountNo))
			return false;
		if (Double.doubleToLongBits(balance) != Double
				.doubleToLongBits(other.balance))
			return false;
		return true;
	}
}
