package com.lizza.file.excel;

import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Joiner;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.junit.Test;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Config {

    @Test
    public void test1() throws Exception {
        String json = "{1378:\"121\", 1387:\"124\", 495:\"80\", 1403:\"129\", 60:\"46\", 1388:\"125\", 780:\"103\", 853:\"117\", 480:\"88\", 7:\"7\", 781:\"104\", 795:\"109\", 617:\"101\", 384:\"86\", 20:\"10\", 713:\"85\", 205:\"105,13\", 440:\"74\", 273:\"71\", 775:\"108\", 712:\"82\", 337:\"102\", 1397:\"127\", 322:\"97\", 797:\"110\", 236:\"72\", 6:\"97,6\", 1401:\"126\", 776:\"107\", 177:\"70\", 4:\"4\", 137:\"91\", 1244:\"120\", 1381:\"123\", 789:\"56\", 3:\"3\", 1233:\"119\", 97:\"48\", 706:\"77\", 996:\"79\", 2:\"2\", 151:\"95\", 870:\"115\", 555:\"81\", 1:\"1,11,111\", 995:\"78\", 896:\"118\", 997:\"89\", 883:\"116\", 464:\"87\", 993:\"84\", 994:\"73\", 499:\"90\", 149:\"94\", 1398:\"128\", 717:\"83\", 5:\"5\", 58:\"47\", 862:\"114\", 152:\"96\", 613:\"76\", 1379:\"122\", 129:\"93\", 642:\"75\",883:\"116\", 862:\"114\", 870:\"115\", 853:\"117\", 896:\"118\"}";
        Map<Integer, String> map = JSONObject.parseObject(json, Map.class);
        Map<Integer, Set<Integer>> result = Maps.newHashMap();
        Set<String> config = Sets.newHashSet();
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            Integer key = entry.getKey();
            String value = entry.getValue();
            Set<Integer> set = Arrays.stream(value.split(",")).map(Integer::valueOf).collect(Collectors.toSet());
            if (result.containsKey(key)) {
                result.get(key).addAll(set);
            } else {
                result.put(key, set);
            }
        }
        for (Map.Entry<Integer, Set<Integer>> entry : result.entrySet()) {
            config.add(entry.getKey() + ":\"" + Joiner.on(",").join(entry.getValue()) + "\"");
        }
        System.out.println(config);
    }
}
