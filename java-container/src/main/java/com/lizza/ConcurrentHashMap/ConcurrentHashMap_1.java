package com.lizza.ConcurrentHashMap;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author lt
 * @date 2019年5月27日
 * @version v1.0
 */
public class ConcurrentHashMap_1 {

	public static void main(String[] args) {
		ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<String, Object>(7);
		for (int i = 0; i < 1000; i++) {
			int finalI = i;
			new Thread(() -> {
			    map.put("k-" + finalI, finalI);
			}, "t-" + i).start();
		}
		System.out.println(map);
	}
}
