package com.lizza.Base;

import com.lizza.util.Logger;
import org.junit.Test;

import java.math.BigDecimal;


public class FloatTests {

    @Test
    public void test1() {

        float a = 1.0f - 0.9f;
        float b = 0.9f - 0.8f;
        // 预期 a 应该是和 b 相同, 事实上 a==b 的结果为 false
        Logger.info("a == b 的结果: {}, a: {}, b: {}", a == b, a, b);

        Float x = Float.valueOf(a);
        Float y = Float.valueOf(b);
        // 预期 a 应该是和 b 相同, 事实上 a==b 的结果为 false
        Logger.info("x.equals(y) 的结果: {}, x: {}, y: {}", x.equals(y), x, y);

        // 使用 BigDecimal 解决精度丢失的问题
        BigDecimal m = new BigDecimal("1.0");
        BigDecimal n = new BigDecimal("0.9");
        BigDecimal p = new BigDecimal("0.9");
        BigDecimal q = new BigDecimal("0.8");
        Logger.info("(1.0f - 0.9f) == (0.9f - 0.8f) 的结果: {}", m.subtract(n) == p.subtract(q));
    }
    
    @Test
    public void test2() {
        System.out.println(1e-6f);
    }
}
