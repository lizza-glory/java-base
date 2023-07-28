package com.lizza.Optional;

import java.util.Optional;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2021-02-21
 */
public class Optional_1 {
    public static void main(String[] args){
        String u = null;
        String s  = (String) Optional.ofNullable(u.toString()).orElse("11");
        System.out.println(s);
    }
}
