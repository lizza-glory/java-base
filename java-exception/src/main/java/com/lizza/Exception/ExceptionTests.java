package com.lizza.Exception;

import org.junit.Test;

/**
 * 
 */
public class ExceptionTests {

    @Test
    public void test1() throws Exception {
        try {
            fun1();
        } catch (CustomeException e) {
            throw e;
        } catch (Exception e) {
            System.out.println("统一异常处理");
        }
    }

    @Test
    public void test2() throws Exception {
        try {
            Integer num = null;
            num.toString();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void fun1() throws CustomeException {
        throw new CustomeException("自定义异常");
    }
    
    public static class CustomeException extends Exception {
        public CustomeException(String message) {
            super(message);
        }
    }
}
