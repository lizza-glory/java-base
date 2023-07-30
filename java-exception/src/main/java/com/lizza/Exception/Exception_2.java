package com.lizza.Exception;

import cn.hutool.core.date.format.FastDateFormat;

import java.text.ParseException;
import java.util.Date;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2022-03-24
 */
public class Exception_2 {

    public static Date parseUTCDate(String dateStr) {
        Date date = null;
        FastDateFormat DATE_PATTERN_UTC_FORMAT = FastDateFormat.getInstance("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        try {
            date = DATE_PATTERN_UTC_FORMAT.parse(dateStr);
        } catch (ParseException e) {
            System.out.println("===============" + e);
        }
        return date;
    }

    public static void main(String[] args){
        System.out.println(parseUTCDate("1530403200000"));
    }
}
