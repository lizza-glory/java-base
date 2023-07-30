package com.lizza.Annotation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Value("1")
    private int id;

    @Value("张三")
    private String name;

    @Value("女")
    private String sex;
}
