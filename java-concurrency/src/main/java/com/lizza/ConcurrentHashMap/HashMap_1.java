package com.lizza.ConcurrentHashMap;

import java.util.HashMap;
import java.util.UUID;

/**
 * 在多线程环境下，使用HashMap进行put操作会引起死循环，导致CPU利用率接近100%， 
 * 所以在并发情况下不能使用HashMap
 * @author lt
 * @date 2019年5月26日
 * @version v1.0
 */
public class HashMap_1 {


	private static HashMap<String, String> map = new HashMap<>(2);
	public static void main(String[] args) {
		for(int i=0; i<10; i++){
			new Thread(new Runnable() {
				@Override
				public void run() {
					for(int j=0; j<1000; j++){
						map.put(UUID.randomUUID().toString(), "");
					}
				}
			}, "线程"+i).start();;
		}
	}
}
