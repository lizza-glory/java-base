package com.lizza.Iterator;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author lt
 * @date 2019年6月15日
 * @version v1.0
 */
public class Iterator_1 {

	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "Java");
		map.put(2, "Python");
		map.put(3, "JavaScript");
		map.put(4, "Sql");
		Iterator<Entry<Integer, String>> it = map.entrySet().iterator();
		while(it.hasNext()){
			Entry<Integer, String> e = it.next();
			System.out.println(e.getKey()+"="+e.getValue());
		}
	}
}
