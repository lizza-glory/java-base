package com.lizza.Json;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class JsonTests {

    @Test
    public void test1() throws Exception {
        String json = "{\"add\":[{\"url\":\"https://cdn.poizon.com/pro-img/origin-img/20230721/2424e35c098b4953a5cf6be6ef3fafeb.jpg\",\"containsChinese\":false},{\"url\":\"https://cdn.poizon.com/pro-img/origin-img/20230721/65189a08d953462b98c37e0612d42e57.jpg\",\"containsChinese\":false},{\"url\":\"https://cdn.poizon.com/pro-img/origin-img/20230721/a1be4fe0ed334621bf45f6b700a2ac28.jpg\",\"containsChinese\":false},{\"url\":\"https://cdn.poizon.com/pro-img/origin-img/20231222/7fe96a18853343f4995d6e431e87ba96.jpg\",\"containsChinese\":false},{\"url\":\"https://cdn.poizon.com/pro-img/origin-img/20231222/d70b33f2e0a748999753a62c2abecf33.jpg\",\"containsChinese\":false}],\"del\":[{\"url\":\"https://cdn.poizon.com/pro-img/origin-img/20220212/556555ff07974729834ec9842a82c55c.jpg\",\"containsChinese\":false},{\"url\":\"https://cdn.poizon.com/pro-img/origin-img/20220212/88babbb1a72040a4a76246fb9120beec.jpg\",\"containsChinese\":false},{\"url\":\"https://cdn.poizon.com/pro-img/origin-img/20220212/a00b7dd8e0f643449052caa0c2ba3f19.jpg\",\"containsChinese\":false}]}";
        JSONObject object = JSONObject.parseObject(json);
        JSONArray add = object.getJSONArray("add");
        for (int i = 0; i < add.size(); i++) {
            System.out.println(add.getJSONObject(i).getString("url"));
        }
        System.out.println("--------");
        JSONArray del = object.getJSONArray("del");
        for (int i = 0; i < del.size(); i++) {
            System.out.println(del.getJSONObject(i).getString("url"));
        }

    }

    /**
     * Gson 转义特殊字符
     * @throws Exception
     */
    @Test
    public void test2() throws Exception {
        Map<String, String> map = Maps.newHashMap();
        map.put("name", "123==.jpg");
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        System.out.println(gson.toJson(map));
    }

    @Test
    public void test3() throws Exception {
        int times = 1;
        while (true) {
            try {
                TimeUnit.MILLISECONDS.sleep(times <<= 1);
                System.out.println(times);
            } catch (Exception e) {

            }
        }
    }
}
