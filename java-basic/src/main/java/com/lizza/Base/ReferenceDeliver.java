package com.lizza.Base;

import org.junit.Test;

/**
 * 测试引用传递和值传递
 */
public class ReferenceDeliver {

    @Test
    public void test1() throws Exception {
        Student student = new Student(1, "张三");
        System.out.println(student);
        rename(student);
        System.out.println(student);
    }

    public void rename(Student student) {
        student.name = "李四";
        student.id = 2;
    }

    @Test
    public void test2() throws Exception {
        int id = 1;
        Integer count = 100;
        System.out.println("before, id: " + id + ", count: " + count);
        change(id, count);
        System.out.println("after, id: " + id + ", count: " + count);
    }

    public void change(int id, Integer count) {
        id = 2;
        count = 200;
    }

}
class Student {
    int id;
    String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}