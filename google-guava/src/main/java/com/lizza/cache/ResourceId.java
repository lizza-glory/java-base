package com.lizza.cache;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Desc: 一次请求中, 资源的唯一标示
 * @author: lizza.liu
 * @date: 2021-08-07
 */
@Data
@Builder
@EqualsAndHashCode
public class ResourceId {

    private String node;
    private Request request;
}
