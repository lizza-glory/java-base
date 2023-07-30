package com.lizza.Reference;

import org.junit.Test;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class WeakReferenceTests {

    /**
     * 弱引用测试
     */
    @Test
    public void test1() throws Exception {
        WeakReference<String> msg = new WeakReference<>(new String("hello world!"));
        System.gc();
        System.out.println("msg: " + msg.get());

        Map<WeakReference<String>, WeakReference<String>> map = new HashMap<>();
        WeakReference<String> key = new WeakReference<>("name");
        map.put(key, new WeakReference<>(new String("栗子")));
        System.gc();
        System.out.println("name: " + map.get(key).get());
    }

    /**
     * 弱引用测试
     */
    @Test
    public void test2() throws Exception {
        WeakReference<String> msg = new WeakReference<>("hello world!");
        System.gc();
        System.out.println("msg: " + msg.get());

        Map<WeakReference<String>, WeakReference<String>> map = new HashMap<>();
        WeakReference<String> key = new WeakReference<>("name");
        map.put(key, new WeakReference<>("栗子"));
        System.gc();
        System.out.println("name: " + map.get(key).get());
    }

    @Test
    public void test3() throws Exception {
        Map<WeakReference<String>, WeakReference<Integer>> map = new HashMap<>();
        WeakReference<String> key = new WeakReference<>("A");
        map.put(key, new WeakReference<>(127));
        System.gc();
        System.out.println("get " + map.get(key).get());
    }

    @Test
    public void test4() throws Exception {
        Map<WeakReference<String>, WeakReference<Integer>> map = new HashMap<>();
        WeakReference<String> key = new WeakReference<>("A");
        map.put(key, new WeakReference<>(128));
        System.gc();
        System.out.println("get " + map.get(key).get());
    }

    @Test
    public void test5() throws Exception {
        Map<WeakReference<String>, WeakReference<Integer>> map = new HashMap<>();
        WeakReference<String> key = new WeakReference<>("A");
        map.put(key, new WeakReference<>(128));
        System.out.println("get " + map.get(key).get());
    }

    @Test
    public void test6() throws Exception {
        Map<WeakReference<String>, WeakReference<Integer>> map = new HashMap<>();
        WeakReference<String> key = new WeakReference<>("A");
        map.put(key, new WeakReference<>(128));
        Thread.sleep(1000);
        System.out.println("get " + map.get(key).get());
    }
}
