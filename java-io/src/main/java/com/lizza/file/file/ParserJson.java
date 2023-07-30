package com.lizza.file.file;

import cn.hutool.core.util.StrUtil;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * @Desc:
 * @author: lizza.liu
 * @date: 2021-08-26
 */
public class ParserJson {

    public static void main(String[] args) throws Exception {
        parser2();
    }

    public static void parser1() throws Exception{
        FileInputStream is = new FileInputStream("/Users/lizza/Downloads/new_guest.log");
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String str;
        while(StrUtil.isNotBlank(str = reader.readLine())) {
            String request = str.substring(str.indexOf("risk_factor_cal_request:") + 24, str.indexOf(",result:"));
            String result = str.substring(str.indexOf(",result:") + 8);
            System.out.println("request: " + request + ", result: " + result);
        }
        is.close();
        reader.close();
    }

    public static void parser2() throws Exception{
        FileInputStream is = new FileInputStream("/Users/lizza/Downloads/new_guest_dubbo.log");
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String str;
        while(StrUtil.isNotBlank(str = reader.readLine())) {
            try {
                String request = str.substring(str.indexOf(") DONE [") + 8, str.indexOf("] Return value("));
                String result = str.substring(str.indexOf("] Return value(") + 14);
                System.out.println("request: " + request + ", result: " + result);
            } catch (Exception e) {
                System.out.println(">>>>>>>>>>>> " + str);
            }
        }
        is.close();
        reader.close();
    }
}
