package com.lizza.Collection;

import java.util.HashMap;
import java.util.Map;

/**
 * 验证hashMap存储时, hashCode相同, equals方法返回false, 会形成链表
 */
public class HashMap_1 {

    public static void main(String[] args){
        User user1 = new User(1, "小明");
        User user2 = new User(2, "小红");
        User user3 = new User(3, "小黑");
        Address addr1 = new Address("北京路");
        Address addr2 = new Address("上海路");
        Address addr3 = new Address("南京路");
        Map<User, Address> map = new HashMap<User, Address>(){{
            put(user1, addr1);
            put(user2, addr2);
            put(user3, addr3);
        }};
    }
}

class User {
    private Integer id;
    private String name;
    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }

    @Override
    public String toString() {
        return "User(id = " + id + ", name = " + name + ")";
    }
}

class Address {
    private String address;
    public Address(String address) {
        this.address = address;
    }
    @Override
    public boolean equals(Object obj) {
        return true;
    }
    @Override
    public String toString() {
        return "Address(address = " + address + ")";
    }
}