package com.lizza.ForTest;

import org.junit.Test;

public class ForTests {

    @Test
    public void test1() throws Exception {
        int start = 1, end = 1000, total = 6270;
        while (true) {
            if (start > end) {
                break;
            }
            System.out.println("读取 " + start + " ~ " + end + " 行");
            start += 1000;
            end = Math.min(end + 1000, total);
        }
    }
}
