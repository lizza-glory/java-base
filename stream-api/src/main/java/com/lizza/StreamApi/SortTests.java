package com.lizza.StreamApi;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;

import java.util.*;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

/**
 * 自定义排序
 */
public class SortTests {

    @Test
    public void test1() throws Exception {
        ArrayList<String> list = Lists.newArrayList("new_user, hotel_count, view_count, city_count");
        list.stream().sorted(String::compareTo).forEach(System.out::println);
    }

    @Test
    public void test2() throws Exception {
        Map<String, Integer> map = new HashMap<String, Integer>(){{
            put("CM", 2);
            put("EU", 3);
        }};
        List<SizeTemplate> list = Lists.newArrayList();
        list.add(SizeTemplate.builder().sizeKey("").sizeValue("36, 37, 38, 39, 40").sort(1).build());
        list.add(SizeTemplate.builder().sizeKey("").sizeValue("36, 37, 38, 39, 40, 41").sort(2).build());
        list.add(SizeTemplate.builder().sizeKey("US M").sizeValue("36, 37, 38, 39, 40, 41").sort(3).build());
        list.add(SizeTemplate.builder().sizeKey("US W").sizeValue("36, 37, 38, 39, 40, 41").sort(4).build());
        list.add(SizeTemplate.builder().sizeKey("").sizeValue("36, 37, 38, 39, 40, 41, 42").sort(5).build());
        list.add(SizeTemplate.builder().sizeKey("EU").sizeValue("36, 37, 38, 39, 40, 41, 42").sort(6).build());
        list.add(SizeTemplate.builder().sizeKey("CM").sizeValue("36, 37, 38, 39, 40, 41, 42").sort(7).build());
        list.stream().sorted(Comparator.comparingInt(new ToIntFunction<SizeTemplate>() {
            @Override
            public int applyAsInt(SizeTemplate value) {
                if (value.getSizeKey().equals("US W")) {
                    return -100;
                }
                if (value.getSizeKey().equals("US M")) {
                    return -99;
                }
                if (map.containsKey(value.getSizeKey())) {
                    return map.get(value.getSizeKey()) - 20;
                }
                return value.getSort();
            }
        }).thenComparingInt(SizeTemplate::getSort)).collect(Collectors.toList()).forEach(System.out::println);
    }
    
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SizeTemplate {

        /**
         * 组名
         */
        private String sizeKey;

        /**
         * 尺码值
         */
        private String sizeValue;

        /**
         * 排序
         */
        private Integer sort;

    }
}
