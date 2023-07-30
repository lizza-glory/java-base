package com.lizza.Annotation;

import com.lizza.util.Logger;
import org.junit.Test;

import java.lang.reflect.Field;

/**
 * java 注解
 */
public class AnnotationTests {

    @Test
    public void test1() throws Exception {
        for (Field field : User.class.getDeclaredFields()) {
            field.setAccessible(true);
            String value = field.getAnnotation(Value.class).value();
            Logger.info("Field: {}, value: {}", field.getName(), value);
        }
    }
}
