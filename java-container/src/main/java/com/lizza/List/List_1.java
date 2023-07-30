package com.lizza.List;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Desc:
 * @author: lizza1643@gmail.com
 * @date: 2019-11-02
 */
public class List_1 {

    public static void main(String[] args){
        List<Integer> list = Lists.newArrayList(1, 2, 3);
        List<Integer> filterList = list.stream().filter(e -> e > 5).collect(Collectors.toList());
        System.out.println(filterList.size());
    }
}
