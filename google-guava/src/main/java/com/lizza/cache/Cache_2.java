package com.lizza.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2021-07-11
 */
public class Cache_2 {

    static Map<String, Object> map = new HashMap<String, Object>(){{
        put("a", 1);
        put("b", 2);
        put("c", 3);
    }};

    private static LoadingCache<String, Optional<Object>> cache = CacheBuilder.newBuilder()
            .expireAfterWrite(3, TimeUnit.SECONDS)
            .maximumSize(128)
            .build(new CacheLoader<String, Optional<Object>>() {
                @Override
                public Optional<Object> load(String key) {
                    return Optional.ofNullable(map.get(key));
                }
            });

    public static void main(String[] args) throws Exception {
        System.out.println(cache.get("a").orElse(null));
        System.out.println(cache.get("e").orElse(null));
    }
}
