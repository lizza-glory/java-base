package com.lizza.List;

import com.google.common.collect.Lists;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Collection;
import java.util.List;

public class ListOperation {

    public static void main(String[] args) {
        List<Integer> list1 = Lists.newArrayList(1, 2, 3);
        List<Integer> list2 = Lists.newArrayList(2, 3, 4);
        Collection<Integer> remain = CollectionUtils.removeAll(list1, list2);
        System.out.println("list1: " + list1 + ", list2: " + list2 + ", remain: " + remain);
    }
}
