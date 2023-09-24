package com.lizza.Map;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.TreeMap;

public class SortedMap {

    @Test
    public void test1() throws Exception {
        String json = "{\"Shoes\":\"29\",\"Apparel\":\"1000095,2\",\"Bags\":\"48\",\"Watches\":\"103\",\"Accessories\":\"92\"}";
        TreeMap treeMap = JSONObject.parseObject(json, TreeMap.class);
        System.out.println(treeMap);
        LinkedHashMap linkedHashMap = JSONObject.parseObject(json, LinkedHashMap.class);
        System.out.println(linkedHashMap);
    }
}
