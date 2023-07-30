package com.lizza.Array;

/**
 * Java数组学习
 * @author lt
 * @date 2019年4月12日
 * @version v1.0
 */
@SuppressWarnings("all")
public class Array_1 {

	public static void main(String[] args) {
		//动态初始化
		int[] arr_1 = new int[8];
		//静态初始化
		int[] arr_2 = {new Integer(1)};
		//添加元素
		arr_1[0] = 1;
		System.out.println(arr_1.toString());
	}
}
