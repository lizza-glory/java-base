package com.lizza.BeanCopy;

import cn.hutool.core.bean.BeanUtil;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BeanCopyTests {

    @Test
    public void test1() throws Exception {
        List<UserDTO.AddressDTO> list = IntStream.range(10000, 10010)
                                                    .mapToObj(value -> UserDTO.AddressDTO.builder().phone(value).address("address-" + value).build())
                                                    .collect(Collectors.toList());
        UserDTO user = UserDTO.builder().name("张胜男").addresses(list).build();
        UserPO result = new UserPO();
        BeanUtils.copyProperties(user, result);
        System.out.println(result);
    }

    @Test
    public void test2() throws Exception {
        List<UserDTO.AddressDTO> list = IntStream.range(10000, 10010)
                                                 .mapToObj(value -> UserDTO.AddressDTO.builder().phone(value).address("address-" + value).build())
                                                 .collect(Collectors.toList());
        UserDTO user = UserDTO.builder().name("张胜男").addresses(list).id(1L).build();
        UserPO result = new UserPO();
        BeanUtil.copyProperties(user, result);
        System.out.println(result);
    }

    @Test
    public void test3() throws Exception {
        Parent parent1 = Parent.builder().id(1).build();
        Child child1 = new Child();
        BeanUtil.copyProperties(parent1, child1);
        System.out.println(child1);

        Child child2 = new Child();
        child2.setName("hello");
        Parent parent2 = Parent.builder().build();
        BeanUtil.copyProperties(child2, parent2);
        System.out.println(parent2);
    }

    @Test
    public void test4() throws Exception {
        BeanCopyTests.print("zhangsan", 1);
    }

    @Test
    public void test5() throws Exception {
        List<UserDTO.AddressDTO> list = IntStream.range(10000, 10010)
                                                 .mapToObj(value -> UserDTO.AddressDTO.builder().phone(value).address("address-" + value).build())
                                                 .collect(Collectors.toList());
        UserDTO user = UserDTO.builder().name("张胜男").addresses(list).id(1L).build();
        UserPO result = new UserPO();
        BeanUtil.copyProperties(user, result);
        System.out.println(result);
    }

    public static void print(Object obj1, Object obj2, String... args) {
        System.out.println(obj1 + ":" + args);
    }

    public static void print(Object obj1, Object obj2, boolean flag) {
        System.out.println(obj1 + ":" + flag);
    }

    public static void print(Object obj1, Class clazz, boolean flag) {
        System.out.println(obj1 + ":" + flag);
    }

//    public static void print(Object obj1, Class clazz, CopyOptions copyOptions) {
//        System.out.println(obj1 + ":" + copyOptions);
//    }
}
