package com.lizza.List.ArrayList;

import java.util.ArrayList;

/**
 * List.ArrayList: addAll
 * @author lt
 * @date 2019年6月9日
 * @version v1.0
 */
public class ArrayList_1 {
	
	public static void main(String[] args) {
		ArrayList<String> list_1 = new ArrayList<String>();
		for (int i = 0; i < 3; i++) {
			list_1.add("No." + i);
		}
		System.out.println("list_1: " + list_1);
		ArrayList<String> list_2 = new ArrayList<String>();
		for (int i = 3; i < 6; i++) {
			list_2.add("No." + i);
		}
		System.out.println("list_2: " + list_2);
		list_1.addAll(list_2);
		System.out.println("list_1: " + list_1);
	}
}
