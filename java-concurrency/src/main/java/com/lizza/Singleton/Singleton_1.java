package com.lizza.Singleton;

/**
 * 单例模式：饿汉形式
 * @author lt
 * @date 2019年5月14日
 * @version v1.0
 */
public class Singleton_1 {
	private static Singleton_1 instance = new Singleton_1();
    private Singleton_1 (){}
    public static Singleton_1 getInstance() {
    	return instance;
    }
}
