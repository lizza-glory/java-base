package com.lizza.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2021-08-07
 */
public class Cache_3 {

    public static void main(String[] args) throws ExecutionException {
        LoadingCache<String, Integer> cache = CacheBuilder.newBuilder()
                .expireAfterAccess(30, TimeUnit.DAYS)
                .maximumSize(10)
                .build(new CacheLoader<String, Integer>() {
                    @Override
                    public Integer load(String key) {
                        int result = new Random().nextInt(10);
                        System.out.println("load data: " + result);
                        return result;
                    }
                });
        for (int i = 0; i < 5; i++) {
            System.out.println(cache.get("key"));
        }
    }
}
