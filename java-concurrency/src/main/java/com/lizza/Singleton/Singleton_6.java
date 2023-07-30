package com.lizza.Singleton;

/**
 * 单例模式：使用静态内部类创建单例
 * @author lt
 * @date 2019年5月14日
 * @version v1.0
 */
public class Singleton_6 {
	private static class Handler{
		private final static Singleton_6 INSTANCE = new Singleton_6();
	}
    private Singleton_6 (){}
	public static Singleton_6 getInstance() {
		return Handler.INSTANCE;
    }
}
