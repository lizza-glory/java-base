package com.lizza.Continer;

import com.google.common.collect.Sets;

import java.util.Set;

public class SetOperations {

    public static void main(String[] args) {
        Set<Integer> set1 = Sets.newHashSet(1, 2, 3);
        Set<Integer> set2 = Sets.newHashSet(3, 4, 5);

        // 交集
        Set<Integer> intersection = Sets.newHashSet(Sets.intersection(set1, set2));
        System.out.println("交集为：" + intersection + ", set1: " + set1 + ", set2: " + set2);

        // 并集
        Set<Integer> union = Sets.newHashSet(Sets.union(set1, set2));
        System.out.println("并集为：" + union);

        // 差集
        Set<Integer> diff = Sets.newHashSet(Sets.difference(set1, set2));
        System.out.println("差集为：" + diff);

        // 利用 remove 实现差集
        set1.removeAll(set2);
        System.out.println("remove: " + set1);
    }
}
