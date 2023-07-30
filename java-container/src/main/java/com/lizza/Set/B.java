package com.lizza.Set;

import java.util.HashSet;
import java.util.Set;

public class B {

    public Set<String> funB() {
        A a = new A();
        Set<String> set = a.funA();
        set.add("HTML");
        set.add("C");
        return set;
    }
}
