package com.lizza.Iterator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Iterator
 * @author lt
 * @date 2019年6月15日
 * @version v1.0
 */
public class Iterator_2 {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0; i<5; i++){
			list.add(i);
		}
		Iterator<Integer> it_1 = list.iterator();
		//1.Iterator遍历List：只能向后遍历，可以移除元素，但不能添加元素
		while(it_1.hasNext()){
			System.out.print(it_1.next()+" ");
		}
		System.out.println();
		//2.ListIterator遍历List：可以向前或者向后遍历元素，可以移除或者添加元素
		ListIterator<Integer> it_2 = list.listIterator();
		//添加元素
		for(int i=5; i<10; i++){
			it_2.add(i);
		}
		while(it_2.hasPrevious()){
			System.out.print(it_2.previous()+" ");
		}
		System.out.println(list);
		System.out.println();
		System.out.println("2.Iterator遍历Map");
		Map<Integer, String> map = new HashMap<>();
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
