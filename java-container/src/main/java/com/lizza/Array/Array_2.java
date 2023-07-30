package com.lizza.Array;

import java.util.Arrays;

/**
 * 数组复制
 * @author lt
 * @date 2019年4月12日
 * @version v1.0
 */
public class Array_2 {

	public static void main(String[] args) {
		int[] arr_1 = {1, 2, 3, 4, 5};
		int[] arr_2 = new int[5];
		System.arraycopy(arr_1, 0, arr_2, 0, 3);
		System.out.println(Arrays.toString(arr_2));
	}
}
