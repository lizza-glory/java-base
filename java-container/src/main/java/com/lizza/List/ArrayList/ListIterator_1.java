package com.lizza.List.ArrayList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * @Desc:
 * @author: lizza1643@gmail.com
 * @date: 2019-11-03
 */
public class ListIterator_1 {
    public static void main(String[] args){
        ArrayList<String> list_1 = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            list_1.add("No." + i);
        }
        ListIterator<String> iterator = list_1.listIterator(3);
        while (iterator.hasPrevious()){
            System.out.println("prev: " + iterator.previousIndex() + ": " + iterator.previous());
        }

        while (iterator.hasNext()){
            System.out.println("next: " + iterator.nextIndex() + ": " + iterator.next());
        }
    }
}
