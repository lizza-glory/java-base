package com.lizza.file.excel;

import cn.hutool.json.JSONUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSONObject;
import com.github.houbb.opencc4j.util.ZhConverterUtil;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 美妆系列信息
 */
public class IdentifyExport_5 {

    public static void main(String[] args) throws Exception {
        String prefix = "【美妆系列信息】";
        String sourceFile = "/Users/admin/Downloads/类目品牌系列源信息.xlsx";
        String targetFile = "/Users/admin/Downloads/翻译信息" + prefix + ".xlsx";

        List<ImportData> seriesNotTranslate = Lists.newArrayList();
        Set<Integer> seriesIds = Sets.newHashSet(0);
        List<ExportData> list = Lists.newArrayList();
        EasyExcel.read(sourceFile, ImportData.class, new AnalysisEventListener<ImportData>() {
            // 每解析一行数据,该方法会被调用一次
            @Override
            public void invoke(ImportData data, AnalysisContext analysisContext) {
                // 品牌
                try {
                    if (!seriesIds.contains(data.getSeriesId())) {
                        String en = data.getEn() == null ? "" : data.getEn();
                        list.add(ExportData.builder()
                                .project("POIZON Server")
                                .titleEn("Common")
                                .singular("单数")
                                .key("identify_productSeries_" + data.getSeriesId())
                                .sourceContent(prefix + data.getSeriesName())
                                .chSimple(data.getSeriesName())
                                .chTraditionalJapan(ZhConverterUtil.convertToTraditional(data.getSeriesName()))
                                .chTraditionalHongKong(ZhConverterUtil.convertToTraditional(data.getSeriesName()))
                                .chTraditionalTaiwan(ZhConverterUtil.convertToTraditional(data.getSeriesName()))
                                .chTraditionalMacau(ZhConverterUtil.convertToTraditional(data.getSeriesName()))
                                .enHongKong(en)
                                .enJapan(en)
                                .enUnitedStates(en)
                                .jpJapan(en)
                                .koKorean(en)
                                .label("4")
                                .build());
                        seriesIds.add(data.getSeriesId());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext analysisContext) {
                // 导出
                EasyExcel.write(targetFile, ExportData.class).sheet("模板").doWrite(list);

            }
        }).sheet(0).doRead();

    }

    /**
     * 获取系列翻译
     *
     * @return
     */
    public static Map<String, TranslateData> getSeriesTranslateData() {
        String file = "/Users/admin/Downloads/系列翻译源信息.xlsx";
        List<TranslateData> list = Lists.newArrayList();
        EasyExcel.read(file, TranslateData.class, new AnalysisEventListener<TranslateData>() {
            // 每解析一行数据,该方法会被调用一次
            @Override
            public void invoke(TranslateData data, AnalysisContext analysisContext) {
                list.add(data);
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext analysisContext) {
            }
        }).sheet(2).doRead();

        Map<String, TranslateData> map = Maps.newHashMap();
        for (TranslateData item : list) {
            if (map.containsKey(item.getCh())) {
                continue;
            }
            map.put(item.getCh(), item);
        }
        System.out.println("系列: " + JSONUtil.toJsonStr(map));
        return map;
    }

    /**
     * 获取系列翻译
     *
     * @return
     */
    public static Map<String, TranslateData> getSecondTranslateData() {
        String file = "/Users/admin/Downloads/系列翻译源信息.xlsx";
        List<TranslateData> list = Lists.newArrayList();
        EasyExcel.read(file, TranslateData.class, new AnalysisEventListener<TranslateData>() {
            // 每解析一行数据,该方法会被调用一次
            @Override
            public void invoke(TranslateData data, AnalysisContext analysisContext) {
                list.add(data);
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext analysisContext) {
            }
        }).sheet(1).doRead();

        Map<String, TranslateData> map = Maps.newHashMap();
        for (TranslateData item : list) {
            if (map.containsKey(item.getCh())) {
                continue;
            }
            map.put(item.getCh(), item);
        }
        System.out.println("二级类目: " + JSONUtil.toJsonStr(map));
        return map;
    }

    /**
     * 获取品牌翻译
     *
     * @return
     */
    public static Map<Integer, List<BrandClassTranslateData>> getBrandTranslateData() {
        String file = "/Users/admin/Downloads/类目品牌系列源信息.xlsx";
        List<BrandClassTranslateData> list = Lists.newArrayList();
        EasyExcel.read(file, BrandClassTranslateData.class, new AnalysisEventListener<BrandClassTranslateData>() {
            // 每解析一行数据,该方法会被调用一次
            @Override
            public void invoke(BrandClassTranslateData data, AnalysisContext analysisContext) {
                list.add(data);
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext analysisContext) {
            }
        }).sheet(0).doRead();

        Map<Integer, List<BrandClassTranslateData>> map = list.stream().collect(Collectors.groupingBy(BrandClassTranslateData::getSecondId));
        System.out.println("品牌: " + JSONUtil.toJsonStr(map));
        return map;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ImportData {

        @ExcelProperty(index = 8, value = "系列 id")
        private Integer seriesId;

        @ExcelProperty(index = 6, value = "系列名称")
        private String seriesName;

        @ExcelProperty(index = 7, value = "系列名称")
        private String en;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TranslateData {

        @ExcelProperty(index = 0)
        private String ch;

        @ExcelProperty(index = 1)
        private String en;

        @ExcelProperty(index = 2)
        private String jp;

        @ExcelProperty(index = 3)
        private String ko;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BrandClassTranslateData {

        @ExcelProperty(index = 1, value = "二级类 id")
        private Integer secondId;

        @ExcelProperty(index = 3, value = "二级类目名称/品牌名称")
        private String name;

        @ExcelProperty(index = 4, value = "品牌 id")
        private Integer brandId;

        @ExcelProperty(index = 5)
        private String en;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ExportData {

        @ExcelProperty("Project名")
        private String project = "POIZON Server";

        @ExcelProperty("pageKey")
        private String pageKey;

        @ExcelProperty("页面title（中文）")
        private String title;

        @ExcelProperty("页面title（英文）*")
        private String titleEn;

        @ExcelProperty("版本翻译变更标签")
        private String change;

        @ExcelProperty("key *")
        private String key;

        @ExcelProperty("服务端key")
        private String serverKey;

        @ExcelProperty("单数/复数 *")
        private String singular = "单数";

        @ExcelProperty("源文案")
        private String sourceContent;

        @ExcelProperty("页面位置或使用场景")
        private String sence;

        @ExcelProperty("图片")
        private String img;

        @ExcelProperty("中国-简中")
        private String chSimple;

        @ExcelProperty("日本-英文")
        private String enJapan;

        @ExcelProperty("日本-日文")
        private String jpJapan;

        @ExcelProperty("韩国-韩语")
        private String koKorean;

        @ExcelProperty("中国香港-英文")
        private String enHongKong;

        @ExcelProperty("美国-英文")
        private String enUnitedStates;

        @ExcelProperty("中国澳门-繁中")
        private String chTraditionalMacau;

        @ExcelProperty("中国台湾-繁中")
        private String chTraditionalTaiwan;

        @ExcelProperty("中国香港-繁中")
        private String chTraditionalHongKong;

        @ExcelProperty("日本-繁中")
        private String chTraditionalJapan;

        @ExcelProperty("更新时间")
        private String updateTime;

        @ExcelProperty("域标签 *")
        private String label;
    }

    @Test
    public void test1() throws Exception {
        String json = "{1:\"1,11,111\", 337:\"102\", 780:\"103\", 781:\"104\", 205:\"13,105\", 2:\"2\", 4:\"4\",3:\"3\", 7:\"7\", 5:\"5\", 6: \"6,97\",789:\"56\", 97:\"48\", 322:\"97\", 177:\"70,10045\",20:\"10\",60:\"46\",776:\"107\",1244:\"120\",149:\"94\",795:\"109\",1378:\"121\", 1387:\"124\", 1381:\"123\", 1403:\"129\", 1388:\"125\", 1233:\"119\", 775:\"108\", 1398:\"128\", 1397:\"127\", 58:\"47\", 151:\"95\", 797:\"110\", 1401:\"126\", 152:\"96\", 1379:\"122\",717:\"10045\", 495:\"10045\", 137:\"10266\", 236:\"10045\", 273:\"10045\", 617:\"10045\", 997:\"10045\", 555:\"10045\", 996:\"10045\", 995:\"10045\", 613:\"10045\", 712:\"10045\", 994:\"10045\", 706:\"10045\", 993:\"10045\", 713:\"1000711\", 499:\"10045\", 642:\"10045\", 129:\"10274\"}";
        System.out.println(json);
        Map<Integer, String> map = JSONObject.parseObject(json, Map.class);
        Map<Integer, String> result = Maps.newHashMap();
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            Set<Integer> set = Sets.newHashSet();
            set.addAll(Arrays.stream(entry.getValue().split(",")).map(Integer::valueOf).collect(Collectors.toSet()));
            if (!result.containsKey(entry.getKey())) {
                result.put(entry.getKey(), Joiner.on(",").join(set));
            }
        }
        System.out.println(JSONUtil.toJsonStr(result));
    }
}
