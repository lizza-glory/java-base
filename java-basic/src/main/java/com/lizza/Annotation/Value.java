package com.lizza.Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解: 对字段进行赋值
 * RetentionPolicy 取值
 * SOURCE: 源文件范围, 运行时无法拿到注解
 * CLASS: 编译文件范围, 运行时无法拿到注解
 * RUNTIME: 运行时注解
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.CLASS)
public @interface Value {

    String value();
}
