package com.lizza.Set;

import java.util.HashSet;
import java.util.Iterator;

/**
 * HashSet原理学习
 * @author lt
 * @date 2019年6月9日
 * @version v1.0
 */
public class HashSet_1 {

	public static void main(String[] args) {
		HashSet<String> set = new HashSet<>();
		set.add("Java");
		set.add("Python");
		set.add("JavaScript");
		set.add(null);
		set.add("Java");
		Iterator<String> iterator = set.iterator();

		System.out.println(set.toString());
	}
}
