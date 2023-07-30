package com.lizza.Singleton;

/**
 * 单例模式：饿汉形式，增加同步，增加判空
 * @author lt
 * @date 2019年5月14日
 * @version v1.0
 */
public class Singleton_3 {
	private static Singleton_3 instance;
    private Singleton_3 (){}
	public static Singleton_3 getInstance() {
		if(instance==null){
			synchronized(Singleton_3.class){
				instance = new Singleton_3();
			}
		}
		return instance;
    }
}
