package com.lizza.unmodifiableMap;

import com.sun.javafx.collections.UnmodifiableObservableMap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @Desc:
 * @author: lizza1643@gmail.com
 * @date: 2019-10-18
 */
public class UnmodifiableMap_1 {

    public static void main(String[] args){
        Map<String, Object> map = new HashMap<>();
        map.put("name", "lizza");
        map.put("age", 18);
        System.out.println(map);
        map = Collections.unmodifiableMap(map);
        map.put("name", "john");
        System.out.println(map);
    }
}
