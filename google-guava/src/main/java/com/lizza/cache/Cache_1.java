package com.lizza.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.junit.Test;

import java.util.Iterator;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2021-06-08
 */
public class Cache_1 {

    /**
     * 基本使用
     */
    @Test
    public void test1() throws Exception{
        LoadingCache<String, Object> cache = CacheBuilder.newBuilder()
                .maximumSize(2)
                .build(new CacheLoader<String, Object>() {
                    @Override
                    public Object load(String key) {
                        return createObj(key);
                    }
                });
        System.out.println(cache.get("A"));
        System.out.println(cache.getAll(new Iterable<String>() {
            @Override
            public Iterator<String> iterator() {
                return null;
            }
        }));
    }

    @Test
    public void test2() throws Exception{
        Cache<String, Object> cache = CacheBuilder.newBuilder().build();
        Object result = cache.get("A", () -> "B");
        System.out.println(result);
    }

    public Object createObj(String key) {
        return key + "-" + key.toLowerCase();
    }
}
