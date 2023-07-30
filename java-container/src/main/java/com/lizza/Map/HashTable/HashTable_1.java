package com.lizza.Map.HashTable;

import java.util.Hashtable;
import java.util.Map;

/**
 * @Desc: HashTable线程安全
 * @author: lizza1643@gmail.com
 * @date: 2019-10-18
 */
public class HashTable_1 {

    public static void main(String[] args) {
        Map<String, String> hashTable = new Hashtable<>();
        hashTable.put("name", "lizza");
        String name = hashTable.get("name");
        System.out.println(name);
    }
}
