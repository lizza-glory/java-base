package com.lizza.ConcurrentHashMap;

import org.junit.Test;

import java.util.concurrent.ConcurrentHashMap;

/**
 * ConcurrentHashMap 源码学习
 *
 */
public class ConcurrentHashMapTests {

	@Test
	public void test1() throws Exception {
		ConcurrentHashMap<Object, Object> map = new ConcurrentHashMap<>(64);
		// put 方法
		User[] users = new User[10];
		for (int i = 0; i < 10; i++) {
			User user = new User(i);
			users[i] = user;
			map.put(user, "用户-" + i);
		}
		System.out.println(map.get(users[1]));
	}

	@Test
	public void test2() throws Exception {
		int n = 8;
		System.out.println(n - (n >>> 2));
	}
}

class User {
	int id;
	public User(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean equals(Object o) {
		return false;
	}
	public int hashCode() {
		return 0;
	}
	public String toString() {
		return "User{" +
				"id=" + id +
				'}';
	}
}