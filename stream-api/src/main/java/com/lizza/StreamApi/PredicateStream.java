package com.lizza.StreamApi;

import java.util.HashSet;
import java.util.Set;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2021-02-20
 */
public class PredicateStream {

    public static final Set<String> AUTHC_URL_PREFIX = new HashSet<String>(){{
        add("/v1/api/");
        add("/v2/api/");
    }};

    public static boolean hasAuthUrl(String path) {
        return AUTHC_URL_PREFIX.stream().anyMatch(prefix -> path.startsWith(prefix));
    }

    public static void main(String[] args){
        String path = "/v3/api/horus/queryStrategyRule";
        System.out.println(hasAuthUrl(path));
    }
}
