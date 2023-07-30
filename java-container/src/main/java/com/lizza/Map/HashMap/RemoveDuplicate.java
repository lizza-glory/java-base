package com.lizza.Map.HashMap;

import java.util.HashMap;
import java.util.Map;

/**
 * @Desc: 利用map去重：
 * @author: lizza1643@gmail.com
 * @date: 2019-08-15
 */
public class RemoveDuplicate {

    public static void main(String[] args){
        Map<Integer, Object> map = new HashMap<>(50);
        for (int i = 0; i < 50; i++) {
            map.put(i, "false");
        }
        System.out.println("all: "+map);
        for (int i = 0; i < 50; i+=3) {
            map.put(i, "true");
        }
        System.out.println("after: "+map);
    }
}
