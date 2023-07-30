package com.lizza.Set;

import java.util.HashSet;
import java.util.Set;

public class A {

    /**
     * 模拟从数据库中获取到数据后放入内存中(set)
     */
    public Set<String> funA() {
        Set<String> set = new HashSet<String>(){{
            add("Java");
            add("Python");
            add("PHP");
        }};
        return set;
    }
}
