package com.lizza.Map.HashMap;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2021-07-15
 */
public class GetOrDefault {

    public static void main(String[] args){
        HashMap<String, HashSet<Integer>> maps = Maps.newHashMap();
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                HashSet<Integer> set = maps.getOrDefault("even", Sets.newHashSet(i));
                set.add(i);
                maps.put("even", set);
            } else {
                maps.getOrDefault("odd", Sets.newHashSet(i)).add(i);
            }
        }
        System.out.println(maps);
    }
}
