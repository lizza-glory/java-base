package com.lizza.Singleton;

/**
 * 单例模式：饿汉形式，增加同步
 * @author lt
 * @date 2019年5月14日
 * @version v1.0
 */
public class Singleton_2 {
	private static Singleton_2 instance = new Singleton_2();
    private Singleton_2 (){}
    public synchronized static Singleton_2 getInstance() {
    	return instance;
    }
}
