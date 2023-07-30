package com.lizza.Singleton;

import java.util.concurrent.atomic.AtomicReference;

/**
 * 单例模式：使用CAS创建单例
 * @author lt
 * @date 2019年5月14日
 * @version v1.0
 */
public class Singleton_5 {
	private static AtomicReference<Singleton_5> atomic = new AtomicReference<>();
    private Singleton_5 (){}
	public static Singleton_5 getInstance() {
		while(true){
			boolean flag = atomic.compareAndSet(null, new Singleton_5());
			if(flag) break;
		}
		return atomic.get();
    }
}
