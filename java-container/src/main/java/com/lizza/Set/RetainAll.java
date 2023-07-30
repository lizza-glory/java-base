package com.lizza.Set;

import com.google.common.collect.Sets;

import java.util.Set;

public class RetainAll {

    public static void main(String[] args) {
        Set<String> set1 = Sets.newHashSet("1", "2", "3", "4", "5");
        Set<String> set2 = Sets.newHashSet("2", "1");
        System.out.println(set1.retainAll(set2));
        System.out.println(set1);
        System.out.println(set2);
    }
}
