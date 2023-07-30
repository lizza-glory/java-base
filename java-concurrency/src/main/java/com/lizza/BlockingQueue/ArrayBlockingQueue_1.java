package com.lizza.BlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author lt
 * @date 2019年5月29日
 * @version v1.0
 */
public class ArrayBlockingQueue_1 {

	public static void main(String[] args) {
		@SuppressWarnings("unused")
		ArrayBlockingQueue<Object> abq = new ArrayBlockingQueue<Object>(16, true, null);
	}
}
