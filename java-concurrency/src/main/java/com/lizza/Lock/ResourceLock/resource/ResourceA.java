package com.lizza.Lock.ResourceLock.resource;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Maps;
import com.lizza.Lock.ResourceLock.service.ServiceA;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2021-07-05
 */
public class ResourceA extends AbstractResourceFactory {

    private LoadingCache<String, Object> cache = CacheBuilder.newBuilder().expireAfterWrite(30, TimeUnit.SECONDS)
            .maximumSize(300)
            .build(new CacheLoader<String, Object>() {
                @Override
                public Object load(String param) {
                    return serviceA.getResult(param);
                }
            });
    private ServiceA serviceA = new ServiceA();

    @Override
    Object fetch(String param) {
        Object result = null;
        try {
            result = cache.get(param);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (Objects.nonNull(result)) {
            System.out.println("\tget result from cache");
            return result;
        }
        return null;
    }
}
