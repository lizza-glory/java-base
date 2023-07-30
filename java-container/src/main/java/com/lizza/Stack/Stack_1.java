package com.lizza.Stack;

import java.util.Stack;

/**
 * 栈：一个线程安全的容器，继承了vector，线程安全，特点是先进后出
 * @author lt
 * @date 2019年6月15日
 * @version v1.0
 */
public class Stack_1{

	public static void main(String[] args) {
		Stack<Integer> s = new Stack<>();
		for(int i=0; i<5; i++){
			s.push(i);
			System.out.println(s);
		}
		for(int i=0; i<5; i++){
			//出栈
			System.out.println(s.pop());
			System.out.println(s);
		}
		
	}
}
