package com.lizza.Map.HashMap;

import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.Random;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2021-07-02
 */
public class PutIfAbsent {

    public static void main(String[] args){
        HashMap<String, Integer> map = Maps.newHashMap();
        map.putIfAbsent("value", getValue());
        map.putIfAbsent("value", getValue());
        System.out.println(map);
    }

    public static Integer getValue() {
        int value = new Random().nextInt(100);
        System.out.println(value);
        return value;
    }
}
