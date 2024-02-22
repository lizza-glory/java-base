package com.lizza.Json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class JsonArrayTests {

    private final static Type TYPE = new TypeToken<List<Map<String, String>>>() {
    }.getType();

    @Test
    public void test1() throws Exception {
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        String json = "[{\"originUrl\":\"https://cdn.poizon.com/du-img/f2d4ce01b08e4730887a50aae1a2fb89&7985d827caaf4e80a6fbabd0e451431d.jpg\",\"url\":\"https://cdn.poizon.com/du-img/f2d4ce01b08e4730887a50aae1a2fb89&7985d827caaf4e80a6fbabd0e451431d.jpg\",\"isDel\":false,\"visible\":true,\"width\":2500,\"height\":2500},{\"originUrl\":\"https://cdn.poizon.com/du-img/b5b63bdc5f0a43a68c8efd1f6f363248&7985d827caaf4e80a6fbabd0e451431d.jpg\",\"url\":\"https://cdn.poizon.com/du-img/b5b63bdc5f0a43a68c8efd1f6f363248&7985d827caaf4e80a6fbabd0e451431d.jpg\",\"isDel\":false,\"visible\":true,\"width\":2500,\"height\":2500},{\"originUrl\":\"https://cdn.poizon.com/du-img/ab714fad83224192a8144202b3ef1660&7985d827caaf4e80a6fbabd0e451431d.jpg\",\"url\":\"https://cdn.poizon.com/du-img/ab714fad83224192a8144202b3ef1660&7985d827caaf4e80a6fbabd0e451431d.jpg\",\"isDel\":false,\"visible\":true,\"width\":2500,\"height\":2500},{\"originUrl\":\"https://cdn.poizon.com/du-img/6d92a14f550a4d52a92cd447497c133e&7985d827caaf4e80a6fbabd0e451431d.jpg\",\"url\":\"https://cdn.poizon.com/du-img/6d92a14f550a4d52a92cd447497c133e&7985d827caaf4e80a6fbabd0e451431d.jpg\",\"isDel\":false,\"visible\":true,\"width\":2500,\"height\":2500},{\"originUrl\":\"https://cdn.poizon.com/node-common/OGZjZTQxZTYtOTFjZC00ZWM4LTg2YTktZGIxMzdlZTU3NzAwMTY5MTM3NTQwMzY0Mg==.jpg\",\"url\":\"https://cdn.poizon.com/node-common/OGZjZTQxZTYtOTFjZC00ZWM4LTg2YTktZGIxMzdlZTU3NzAwMTY5MTM3NTQwMzY0Mg==.jpg\",\"isDel\":false,\"visible\":true,\"width\":2500,\"height\":1600}]";
        System.out.println(json);
        List<Map<String, String>> array = gson.fromJson(json, TYPE);
        for (Map<String, String> item : array) {
            System.out.println(gson.toJson(item));
        }
    }

    @Test
    public void test2() throws Exception {

    }
}
