package com.lizza.Set;

import com.google.common.collect.Sets;

import java.util.HashSet;
import java.util.Set;

/**
 * 集合复制
 */
public class Guava_Set {

    public static void main(String[] args){
        Set<String> set = new HashSet<>();
        for (int i = 0; i < 100; i++) {
            set.add("e" + i);
        }
        Sets.newHashSet(set);
    }
}
