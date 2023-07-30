package com.lizza.file.excel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.lizza.file.util.Logger;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class ExcelImport_1 {

    private static List<SpuImgItem> doAnalyze(InputStream stream) throws IOException {
        List<SpuImgItem> list = Lists.newArrayList();
        EasyExcel.read(stream, SpuImgItem.class, new AnalysisEventListener<SpuImgItem>() {
            @Override
            public void invoke(SpuImgItem data, AnalysisContext context) {
                checkImgExist(data);
                String needDelImg = data.getNeedDelImg();
                if (StringUtils.isBlank(needDelImg)) {
                    return;
                }
                data.setNeedDelImgSet(Stream.of(needDelImg.split(",")).collect(Collectors.toSet()));
                list.add(data);
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext context) {
                System.out.println("doAfterAllAnalysed");
            }

        }).sheet(0).doRead();
        return list;
    }

    private static void checkImgExist(SpuImgItem data) {
        String needDelImg = data.getNeedDelImg();
        if (StringUtils.isBlank(needDelImg)) {
            return;
        }
        String[] array = needDelImg.split(",");
        String delImgs = StringUtils.isBlank(data.getDelImgs()) ? "" : data.getDelImgs();
        for (String img : array) {
            if (delImgs.contains(img)) {
                continue;
            }
            throw new RuntimeException("图片不存在, img: " + img);
        }
    }

    @Data
    public static class SpuImgItem {

        @ExcelProperty("得物spu")
        private Long spuId;

        @ExcelProperty("商品名称")
        private String title;

        @ExcelProperty("品牌")
        private String brand;

        @ExcelProperty("新增的图片")
        private String addImgs;

        @ExcelProperty("删除的图片")
        private String delImgs;

        @ExcelProperty("新增图片数")
        private String addCount;

        @ExcelProperty("删除图片数")
        private String delCount;

        @ExcelProperty("需要删除的图片")
        private String needDelImg;

        private Set<String> needDelImgSet;
    }

    public static void main(String[] args) throws Exception {
        FileInputStream stream = new FileInputStream("/Users/admin/Downloads/得物、自建站图片变更清单.xlsx");
        List<SpuImgItem> list = doAnalyze(stream);
        Logger.info("list: {}", JSONObject.toJSON(list));
        Logger.info("finished~");
        stream.close();
    }
}
