package com.lizza.Array;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;

import java.util.Map;

public class JSONArrayTests {

    @Test
    public void test1() throws Exception {
        String images = "[{\"url\":\"https://hkpoizon-img.poizon.com/du_app/2023/image/123456_modelXQ-AS72model_byte48075byte_9114ad14249e97e75fa8d5db1518b389_du_android_w1080_h1080.png\"},{\"url\":\"https://hkpoizon-img.poizon.com/du_app/2023/image/123456_modelXQ-AS72model_byte53334byte_d99a4cbf8021f1f5a2b9e5a89b33ac9c_du_android_w1080_h1080.png\"},{\"url\":\"https://hkpoizon-img.poizon.com/du_app/2023/image/123456_modelXQ-AS72model_byte53334byte_be1ed5029abcd64d4c0e33ece0e72335_du_android_w1080_h1080.png\"},{\"url\":\"https://hkpoizon-img.poizon.com/du_app/2023/image/123456_modelXQ-AS72model_byte49759byte_6322f6e66892202bde7683b1bd9f4d7b_du_android_w1080_h1080.png\"},{\"url\":\"https://hkpoizon-img.poizon.com/du_app/2023/image/123456_modelXQ-AS72model_byte56830byte_3fb64f940c4bbeb36d4897e3e1701f08_du_android_w1080_h1080.png\"},{\"url\":\"https://hkpoizon-img.poizon.com/du_app/2023/image/123456_modelXQ-AS72model_byte56830byte_c86fd9f94b65fcdce5090cb5e2ab5570_du_android_w1080_h1080.png\"}]";
        Param param = Param.builder().id(1).images(images).build();
        replace(param);
        System.out.println(JSONObject.toJSON(param));
    }

    @Test
    public void test2() throws Exception {
        // 数组解析失败
//        JSONArray array1 = JSON.parseArray(JSON.toJSONString("[]"));
//        System.out.println(array1);
        Map<String, Object> map = Maps.newHashMap();
        map.put("images", Lists.newArrayList());
        JSONArray array2 = JSON.parseArray(JSON.toJSONString(map.get("images")));
        System.out.println(map.get("images") == null);
        System.out.println(array2);
    }

    public void replace(Param param) {
        String images = param.getImages();
        JSONArray array = JSONArray.parseArray(images);
        for (int i = 0; i < array.size(); i++) {
            JSONObject object = array.getJSONObject(i);
            String url = object.getString("url").replaceFirst("https", "http");
            object.put("url", url);
        }
        param.setImages(JSONObject.toJSONString(array));
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Param {

        private int id;

        private String images;
    }
}
