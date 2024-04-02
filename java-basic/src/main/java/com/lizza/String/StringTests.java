package com.lizza.String;

import cn.hutool.json.JSONUtil;
import com.google.common.collect.Lists;
import com.lizza.util.Logger;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class StringTests {

    @Test
    public void test1() throws Exception {
        String description = String.join("", "（", "名牌大学", "）");
        System.out.println(description);
        System.out.println(description.lastIndexOf("）1") == description.length() - 1);
        System.out.println(String.join("", description.substring(0, description.length() - 1), "-第2名）"));
    }

    @Test
    public void test2() throws Exception {
        String json = "{\"code\":0,\"codeType\":0,\"data\":{\"allHrRelationsInfo\":{\"2025466\":{\"allRelations\":0,\"boundRelations\":0,\"hrWorkWechatBound\":false},\"2025540\":{\"allRelations\":0,\"boundRelations\":0,\"hrWorkWechatBound\":true,\"thirdPartyUserId\":\"woYPMqCAAAnyj_vYprO56M0hD7U-E3pQ\"},\"2025541\":{\"allRelations\":0,\"boundRelations\":0,\"hrWorkWechatBound\":false},\"2098972\":{\"allRelations\":0,\"boundRelations\":0,\"hrWorkWechatBound\":false},\"2221950\":{\"allRelations\":0,\"boundRelations\":0,\"hrWorkWechatBound\":false},\"2223667\":{\"allRelations\":0,\"boundRelations\":0,\"hrWorkWechatBound\":false},\"2223672\":{\"allRelations\":2,\"boundRelations\":0,\"hrWorkWechatBound\":true,\"thirdPartyUserId\":\"hanxiunan-179863\"},\"2223679\":{\"allRelations\":0,\"boundRelations\":0,\"hrWorkWechatBound\":false},\"2223881\":{\"allRelations\":0,\"boundRelations\":0,\"hrWorkWechatBound\":false},\"2223882\":{\"allRelations\":0,\"boundRelations\":0,\"hrWorkWechatBound\":false},\"2225618\":{\"allRelations\":0,\"boundRelations\":0,\"hrWorkWechatBound\":false},\"2227530\":{\"allRelations\":0,\"boundRelations\":0,\"hrWorkWechatBound\":true,\"thirdPartyUserId\":\"woYPMqCAAAYC2rS22Esu5YJJdvt9JV9g\"},\"2280475\":{\"allRelations\":0,\"boundRelations\":0,\"hrWorkWechatBound\":false},\"2282764\":{\"allRelations\":0,\"boundRelations\":0,\"hrWorkWechatBound\":true,\"thirdPartyUserId\":\"woYPMqCAAA9izPAtPtBvIFwESKAr2iOQ\"},\"2282772\":{\"allRelations\":0,\"boundRelations\":0,\"hrWorkWechatBound\":false},\"2288521\":{\"allRelations\":0,\"boundRelations\":0,\"hrWorkWechatBound\":false},\"2307629\":{\"allRelations\":0,\"boundRelations\":0,\"hrWorkWechatBound\":false},\"2309330\":{\"allRelations\":0,\"boundRelations\":0,\"hrWorkWechatBound\":false},\"2309331\":{\"allRelations\":0,\"boundRelations\":0,\"hrWorkWechatBound\":false},\"2311359\":{\"allRelations\":0,\"boundRelations\":0,\"hrWorkWechatBound\":false},\"2367034\":{\"allRelations\":2,\"boundRelations\":0,\"hrWorkWechatBound\":true,\"thirdPartyUserId\":\"ZhangWuJie_13\"},\"2403219\":{\"allRelations\":0,\"boundRelations\":0,\"hrWorkWechatBound\":false},\"2444862\":{\"allRelations\":0,\"boundRelations\":0,\"hrWorkWechatBound\":false},\"2502008\":{\"allRelations\":0,\"boundRelations\":0,\"hrWorkWechatBound\":false},\"2538897\":{\"allRelations\":0,\"boundRelations\":0,\"hrWorkWechatBound\":false},\"2570016\":{\"allRelations\":0,\"boundRelations\":0,\"hrWorkWechatBound\":false},\"2574913\":{\"allRelations\":0,\"boundRelations\":0,\"hrWorkWechatBound\":false},\"2575240\":{\"allRelations\":0,\"boundRelations\":0,\"hrWorkWechatBound\":false},\"2605067\":{\"allRelations\":0,\"boundRelations\":0,\"hrWorkWechatBound\":false},\"2642520\":{\"allRelations\":2,\"boundRelations\":0,\"hrWorkWechatBound\":true,\"thirdPartyUserId\":\"TianYu\"},\"2642521\":{\"allRelations\":4,\"boundRelations\":0,\"hrWorkWechatBound\":true,\"thirdPartyUserId\":\"LongXuan\"},\"2646707\":{\"allRelations\":0,\"boundRelations\":0,\"hrWorkWechatBound\":false},\"2650078\":{\"allRelations\":39,\"boundRelations\":6,\"hrWorkWechatBound\":true,\"thirdPartyUserId\":\"WangKunLun\"},\"2650079\":{\"allRelations\":7,\"boundRelations\":4,\"hrWorkWechatBound\":true,\"thirdPartyUserId\":\"FuWanRong\"},\"2659263\":{\"allRelations\":5,\"boundRelations\":1,\"hrWorkWechatBound\":true,\"thirdPartyUserId\":\"LiChen\"},\"2663066\":{\"allRelations\":6,\"boundRelations\":0,\"hrWorkWechatBound\":true,\"thirdPartyUserId\":\"LiuTao\"},\"2668128\":{\"allRelations\":0,\"boundRelations\":0,\"hrWorkWechatBound\":true,\"thirdPartyUserId\":\"DuFuYun\"},\"2799621\":{\"allRelations\":0,\"boundRelations\":0,\"hrWorkWechatBound\":false},\"2800159\":{\"allRelations\":0,\"boundRelations\":0,\"hrWorkWechatBound\":false},\"2800588\":{\"allRelations\":0,\"boundRelations\":0,\"hrWorkWechatBound\":false},\"2845762\":{\"allRelations\":0,\"boundRelations\":0,\"hrWorkWechatBound\":true,\"thirdPartyUserId\":\"WangShi\"},\"2866460\":{\"allRelations\":0,\"boundRelations\":0,\"hrWorkWechatBound\":false},\"2868629\":{\"allRelations\":0,\"boundRelations\":0,\"hrWorkWechatBound\":false},\"2870739\":{\"allRelations\":0,\"boundRelations\":0,\"hrWorkWechatBound\":false},\"2965615\":{\"allRelations\":0,\"boundRelations\":0,\"hrWorkWechatBound\":false},\"2967304\":{\"allRelations\":0,\"boundRelations\":0,\"hrWorkWechatBound\":false},\"2976459\":{\"allRelations\":0,\"boundRelations\":0,\"hrWorkWechatBound\":false},\"2988064\":{\"allRelations\":0,\"boundRelations\":0,\"hrWorkWechatBound\":false},\"2989935\":{\"allRelations\":0,\"boundRelations\":0,\"hrWorkWechatBound\":false},\"2993650\":{\"allRelations\":0,\"boundRelations\":0,\"hrWorkWechatBound\":false},\"2996992\":{\"allRelations\":0,\"boundRelations\":0,\"hrWorkWechatBound\":true,\"thirdPartyUserId\":\"woYPMqCAAAgvqHUIT75SSj8jhL7WTgrQ\"},\"3228476\":{\"allRelations\":0,\"boundRelations\":0,\"hrWorkWechatBound\":false},\"3230095\":{\"allRelations\":0,\"boundRelations\":0,\"hrWorkWechatBound\":false},\"3315123\":{\"allRelations\":0,\"boundRelations\":0,\"hrWorkWechatBound\":false}},\"version\":\"1.0\"},\"msg\":\"成功\",\"success\":true}";
        System.out.println(json);
        JSONUtil.parseObj(json).getJSONObject("data").getJSONObject("allHrRelationsInfo").forEach((s, o) -> {
            Map<String, Object> item = (Map<String, Object>) o;
            boolean hrWorkWechatBound = (boolean) item.get("hrWorkWechatBound");
            if (hrWorkWechatBound) {
                System.out.println("key: " + s + ", value: " + item.get(""));
            }
        });
    }

    @Test
    public void test3() throws Exception {
        System.out.println("张侦".equals("张侦"));
    }

    /**
     * 有个 CDN 的白名单列表, 客户端提交的图片地址, 需要校验是否在白名单列表中, 如果不在, 抛出异常
     * @throws Exception
     */
    @Test
    public void test4() throws Exception {
        String url = "https://hkpoizon-img.poizon.com/du_app/2023/image/123456_modelXQ-AS72model_byte49515byte_8d045f71cbc8d4c4d066f28b63d8716b_du_android_w1080_h1080.png";
        System.out.println(url.split("/")[2]);
    }

    @Test
    public void test5() throws Exception {
        List<String> cdnList = Lists.newArrayList("t1-frontend-cdn.dewu.net");
        String host = "t1-frontend-cdn.dewu.net";
        if (!cdnList.contains(host)) {
            Logger.info("URL 不在 CDN 列表中");
        } else {
            Logger.info("恭喜: URL 在 CDN 列表中");
        }
    }

    @Test
    public void test6() throws Exception {
        String string = "[新品申请状态变更-商研审核不通过] 商品无法辨别";
        System.out.println(string.split("]")[1].trim());
        System.out.println(string.indexOf("]"));
        System.out.println("商品货号已存在，请检查后重试,重复的ID[1186169];该货号已存在新品申请,重复的新品申请ID[51492]，重复上架".startsWith("["));
        System.out.println("[新品申请状态变更-商研审核不通过] 商品无法辨别".startsWith("["));
    }

    @Test
    public void test7() throws Exception {
    }
}
