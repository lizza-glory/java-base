package com.lizza.Set;

import com.google.common.collect.Sets;

import java.util.Set;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2021-07-15
 */
public class ContainsAll {

    public static void main(String[] args){
        Set<String> set1 = Sets.newHashSet("1", "2", "3", "4", "5");
        Set<String> set2 = Sets.newHashSet("2", "1");
        System.out.println(set1.containsAll(set2));
    }
}
