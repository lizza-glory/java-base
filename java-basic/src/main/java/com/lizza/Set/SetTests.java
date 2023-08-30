package com.lizza.Set;

import com.google.common.collect.Sets;
import org.junit.Test;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class SetTests {

    @Test
    public void test1() throws Exception {
        Set<Integer> set1 = Sets.newHashSet(10286,18192,1646,1653,1654,1665,1666,10287,10288,10494,10495,10500,10503,10505,10507,10509,10510,10511,10512,17894,17895,18173,18174,1592,1593,1573,1574,1584,1585,1601,1602,1563,1564,9373,9374,4639,4640,4653,4654,4656,5893,5894,12496,12497,13083,13084,13085,12505,12506,15773,15774,12514,12515,12526,12527,12528,12529,12540,12541,12542,12543,7069,7070,8294,8295,8297,9465,9466,9467,9530,9531,9535,1946,3182,6368,15704,1411,1412,2816,2821);
        Set<Integer> set2 = Sets.newHashSet(1946,10287,10288,10287,10288,10287,10288,10494,10495,10500,10503,10505,10507,10509,10510,10511,10512,10286,1592,1593,1573,1574,1584,1585,1601,1602,1563,1564,3182,12505,12506,13083,13084,13085,8294,8295,8297,4639,4640,4653,4654,4656,1411,1412,15704,6368,7069,7070,9465,9466,9467,9530,9531,9535,12496,12497,12514,12515,15773,15774,12526,12527,12528,12529,12540,12541,12542,12543);
        set1.removeAll(set2);
        System.out.println(set1);
    }

    @Test
    public void test2() throws Exception {
        Set<Integer> set1 = Sets.newHashSet(1, 2, 3, 4);
        Set<Integer> set2 = Sets.newHashSet(2, 3);
        set1.removeAll(set2);
        System.out.println(set1);
    }

    @Test
    public void test3() throws Exception {
        Set<Integer> set1 = Sets.newHashSet(1, 2, 3, 4);
        Set<Integer> set2 = Sets.newHashSet(2, 3);
        Set<Integer> difference = Sets.newHashSet(Sets.difference(set1, set2));
        System.out.println(set1);
    }

    @Test
    public void test4() throws Exception {
        Set<Integer> set1 = Sets.newHashSet(2, 3, 4);
        Set<Integer> set2 = Sets.newHashSet(4, 3, 2);
        System.out.println(set1.equals(set2));
        System.out.println(Objects.equals(set1, set2));
    }
}
