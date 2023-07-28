package com.lizza.Enum;

/**
 * 表结构解析器, 模拟 new TypeReference<TagsPO>
 */
public class TableParser<T> {

    public TableParser () {
        System.out.println("TableParser construct method invoked");
    }

    public T parse() {
        return (T) new Object();
    }
}
