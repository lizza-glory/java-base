package com.lizza.List.ArrayList;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @Desc:
 * @author: lizza1643@gmail.com
 * @date: 2019-11-03
 */
public class Iterator_1 {

    public static void main(String[] args){
        ArrayList<String> list_1 = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            list_1.add("No." + i);
        }
        Iterator<String> iterator = list_1.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
            iterator.remove();
        }
        System.out.println(list_1);
    }
}
