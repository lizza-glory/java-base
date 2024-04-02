package com.lizza.joiners;

import com.google.common.base.Joiner;
import org.junit.Test;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2021-02-25
 */
public class JoinerTests {

    @Test
    public void test1() throws Exception {
        String title = Stream.of("lizza", null).filter(Objects::nonNull).collect(Collectors.joining("/"));
        System.out.println(title);

        System.out.println("{\"createdBy\":\"MABANG\",\"pageSize\":100,\"pageNum\":7}");

        System.out.println(String.format("du:commodity:front:brand:ext:list:%s", null));
    }

}
