package com.lizza.Map.HashMap;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Hash 冲突
 *
 * 没有重写 hashCode 或 equals
 * 两个 key: a 和 b, 从业务角度, a 和 b 表示同一个 key
 * 1. hashCode 相同, equals 不同
 *
 *
 * 2. hashCode 相同, equals 相同
 *    直接替换 value
 */
public class HashConflict {

    class Key {
        String key;

        public Key(String key) {
            this.key = key;
        }

        @Override
        public int hashCode() {
            return key.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            return key.equals(obj);
        }

        @Override
        public String toString() {
            return key;
        }
    }

    @Test
    public void test1() {
        Map<Key, Object> map = new HashMap<>();
        for (int i = 0; i < 20; i++) {
            map.put(new Key("k-" + i), i);
        }
        System.out.println(map.get(new Key("k-1")));
    }

    @Test
    public void test2() {

    }
}
