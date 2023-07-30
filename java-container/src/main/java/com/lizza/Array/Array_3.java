package com.lizza.Array;

import java.util.Arrays;
import java.util.List;

/**
 * 数组常见的使用错误
 * @author lt
 * @date 2019年4月12日
 * @version v1.0
 */
public class Array_3 {

	public static void main(String[] args) {
		//1.基本类型数组
		int[] arr_1 = {1, 2, 3, 4, 5};
		List<int[]> list_1 = Arrays.asList(arr_1);
		//输出1
		System.out.println(list_1);
		System.out.println(list_1.size());
		/**
		 * 原因：
		 */
		//2.引用类型
		String[] arr_2 = {"Java", "Python", "SQL"};
		List<String> list_2 = Arrays.asList(arr_2);
		//输出3
		System.out.println(list_2.size());
		
	}
}
