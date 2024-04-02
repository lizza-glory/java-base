package com.lizza.easy.excel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.google.gson.*;
import lombok.Data;
import org.apache.poi.ss.formula.functions.T;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Reader {

    private Gson gson = new GsonBuilder().disableHtmlEscaping().create();
    private JsonParser parser = new JsonParser();

    @Test
    public void test1() throws Exception {
        System.out.println(1000079977%128);
    }

    @lombok.Data
    public static class Data {

        @ExcelProperty("语言")
        private String language;

        @ExcelProperty("原始名称")
        private String sourceValue;

        @ExcelProperty("翻译后名称")
        private String translateValue;
    }
}
