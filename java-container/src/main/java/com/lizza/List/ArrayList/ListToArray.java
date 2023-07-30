package com.lizza.List.ArrayList;

import java.util.Arrays;
import java.util.List;

/**
 * 1. 数组转为ArrayList
 * 2. 转为数组后不可以编辑元素
 */
public class ListToArray {

    public static void main(String[] args){
        int[] array = new int[]{1, 2, 3};
        List<int[]> list = Arrays.asList(array);
        list.add(new int[]{4});
    }
}
