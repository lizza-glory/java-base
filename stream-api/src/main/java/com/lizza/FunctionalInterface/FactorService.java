package com.lizza.FunctionalInterface;

import java.util.function.Function;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2021-06-25
 */
public class FactorService {

    public static void main(String[] args){
        IFactor factor = new CommonFactor();
//        System.out.println(CommonFactor::getName);
    }

    public Object getFactorResult(IFactor factor, Function<IFactor, Object> function) {
        return function.apply(factor);
    }
}
