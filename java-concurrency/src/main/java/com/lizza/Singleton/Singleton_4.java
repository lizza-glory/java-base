package com.lizza.Singleton;

/**
 * 单例模式：饿汉形式，增加同步，增加判空，禁止重排序
 * @author lt
 * @date 2019年5月14日
 * @version v1.0
 */
public class Singleton_4 {
	private volatile static Singleton_4 instance;
    private Singleton_4 (){}
	public static Singleton_4 getInstance() {
		if(instance==null){
			synchronized(Singleton_4.class){
				instance = new Singleton_4();
			}
		}
		return instance;
    }
}
