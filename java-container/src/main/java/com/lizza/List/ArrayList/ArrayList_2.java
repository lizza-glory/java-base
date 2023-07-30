package com.lizza.List.ArrayList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 修改ArrayList中的元素
 * @author lt
 * @date 2019年6月9日
 * @version v1.0
 */
public class ArrayList_2 {
	
	public static void main(String[] args) {
		ArrayList<Map<Integer, Object>> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			Map<Integer, Object> map = new HashMap<>();
			map.put(i, "o"+i);
			list.add(map);
		}
		System.out.println(list);
		list.get(0).put(1, "o00");
		System.out.println(list);
	}
}
