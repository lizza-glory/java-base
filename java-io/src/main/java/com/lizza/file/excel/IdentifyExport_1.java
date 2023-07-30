package com.lizza.file.excel;

import cn.hutool.json.JSONUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.github.houbb.opencc4j.util.ZhConverterUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.lizza.file.util.Logger;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 奢包, 运动户外,露营装备-二级类目拍摄步骤信息
 */
public class IdentifyExport_1 {

    public static void main(String[] args) throws Exception {
        String sourceFile = "/Users/admin/Downloads/拍摄位源信息.xlsx";
        String targetFile = "/Users/admin/Downloads/翻译信息(导出).xlsx";

        // 系列翻译数据
        Map<String, TranslateData> seriesTranslateData = getSeriesTranslateData();
        Map<String, TranslateData> secondTranslateData = getSecondTranslateData();
        Map<Integer, List<BrandClassTranslateData>> brandTranslateData = getBrandTranslateData();

        Set<Integer> secondPromptIds = Sets.newHashSet();
        Set<Integer> secondClassIds = Sets.newHashSet();
        Set<Integer> brandIds = Sets.newHashSet();

        List<ImportData> seriesNotTranslate = Lists.newArrayList();
        List<ImportData> promptNotTranslate = Lists.newArrayList();
        List<ImportData> brandNotTranslate = Lists.newArrayList();
        List<ImportData> secondNotTranslate = Lists.newArrayList();
        Set<String> config = Sets.newHashSet();

        List<ExportData> list = Lists.newArrayList();
        EasyExcel.read(sourceFile, ImportData.class, new AnalysisEventListener<ImportData>() {
            // 每解析一行数据,该方法会被调用一次
            @Override
            public void invoke(ImportData data, AnalysisContext analysisContext) {
//                if (!data.getSecondId().equals(110)) {
//                    return;
//                }
                // 系列
                try {
                    list.add(ExportData.builder()
                            .project("POIZON Server")
                            .titleEn("Common")
                            .singular("单数")
                            .key("identify_step_" + data.getPromptId())
                            .sourceContent("【鉴别类目】" + data.getPromptInfo())
                            .chSimple(data.getPromptInfo())
                            .chTraditionalJapan(ZhConverterUtil.convertToTraditional(data.getPromptInfo()))
                            .chTraditionalHongKong(ZhConverterUtil.convertToTraditional(data.getPromptInfo()))
                            .chTraditionalTaiwan(ZhConverterUtil.convertToTraditional(data.getPromptInfo()))
                            .chTraditionalMacau(ZhConverterUtil.convertToTraditional(data.getPromptInfo()))
                            .enHongKong(seriesTranslateData.get(data.getPromptInfo()).getEn())
                            .enJapan(seriesTranslateData.get(data.getPromptInfo()).getEn())
                            .enUnitedStates(seriesTranslateData.get(data.getPromptInfo()).getEn())
                            .jpJapan(seriesTranslateData.get(data.getPromptInfo()).getJp())
                            .koKorean(seriesTranslateData.get(data.getPromptInfo()).getKo())
                            .label("4")
                            .build());
                    config.add(data.getSecondPromptId() + ":\"" + data.getSecondId() + "\"");
                } catch (Exception e) {
                    seriesNotTranslate.add(data);
                }

                // 拍摄提示
                try {
                    if (!secondPromptIds.contains(data.getSecondPromptId())) {
                        list.add(ExportData.builder()
                                .project("POIZON Server")
                                .titleEn("Common")
                                .singular("单数")
                                .key("Identify_prompt_" + data.getSecondPromptId())
                                .sourceContent("【鉴别类目】" + data.getSecondName())
                                .chSimple(data.getPromptInfo())
                                .chTraditionalJapan(data.getPromptInfo())
                                .chTraditionalHongKong(data.getPromptInfo())
                                .chTraditionalTaiwan(data.getPromptInfo())
                                .chTraditionalMacau(data.getPromptInfo())
                                .enHongKong(data.getPromptInfo())
                                .enJapan(data.getPromptInfo())
                                .enUnitedStates(data.getPromptInfo())
                                .jpJapan(data.getPromptInfo())
                                .koKorean(data.getPromptInfo())
                                .label("4")
                                .build());
                        secondPromptIds.add(data.getSecondPromptId());
                    }
                } catch (Exception e) {
                    promptNotTranslate.add(data);
                }

                // 二级类目
                try {
                    if (!secondClassIds.contains(data.getSecondId())) {
                        list.add(ExportData.builder()
                                .project("POIZON Server")
                                .titleEn("Common")
                                .singular("单数")
                                .key("identify_SecondClass_" + data.getSecondId())
                                .sourceContent("【鉴别类目】" + data.getSecondName())
                                .chSimple(data.getSecondName())
                                .chTraditionalJapan(ZhConverterUtil.convertToTraditional(data.getSecondName()))
                                .chTraditionalHongKong(ZhConverterUtil.convertToTraditional(data.getSecondName()))
                                .chTraditionalTaiwan(ZhConverterUtil.convertToTraditional(data.getSecondName()))
                                .chTraditionalMacau(ZhConverterUtil.convertToTraditional(data.getSecondName()))
                                .enHongKong(secondTranslateData.get(data.getSecondName()).getEn())
                                .enJapan(secondTranslateData.get(data.getSecondName()).getEn())
                                .enUnitedStates(secondTranslateData.get(data.getSecondName()).getEn())
                                .jpJapan(secondTranslateData.get(data.getSecondName()).getJp())
                                .koKorean(secondTranslateData.get(data.getSecondName()).getKo())
                                .label("4")
                                .build());
                        secondClassIds.add(data.getSecondId());
                    }
                } catch (Exception e) {
                    secondNotTranslate.add(data);
                }

                try {
                    // 品牌
                    for (BrandClassTranslateData item : brandTranslateData.get(data.getSecondId())) {
                        if (!brandIds.contains(item.getBrandId())) {
                            list.add(ExportData.builder()
                                    .project("POIZON Server")
                                    .titleEn("Common")
                                    .singular("单数")
                                    .key("identify_brand_" + item.getBrandId())
                                    .sourceContent("【鉴别类目】" + item.getName())
                                    .chSimple(item.getName())
                                    .chTraditionalJapan(ZhConverterUtil.convertToTraditional(item.getName()))
                                    .chTraditionalHongKong(ZhConverterUtil.convertToTraditional(item.getName()))
                                    .chTraditionalTaiwan(ZhConverterUtil.convertToTraditional(item.getName()))
                                    .chTraditionalMacau(ZhConverterUtil.convertToTraditional(item.getName()))
                                    .enHongKong(item.getEn())
                                    .enJapan(item.getEn())
                                    .enUnitedStates(item.getEn())
                                    .jpJapan(item.getEn())
                                    .koKorean(item.getEn())
                                    .label("4")
                                    .build());
                            brandIds.add(item.getBrandId());
                        }
                    }
                } catch (Exception e) {
                    brandNotTranslate.add(data);
                }
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext analysisContext) {
                // 导出
                EasyExcel.write(targetFile, ExportData.class).sheet("模板").doWrite(list);
                Logger.info("拍摄位未翻译: {}", JSONUtil.toJsonStr(seriesNotTranslate.stream().map(ImportData::getPromptInfo).collect(Collectors.toList())));
                Logger.info("拍摄提示未翻译: {}", JSONUtil.toJsonStr(promptNotTranslate));
                Logger.info("二级类目未翻译: {}", JSONUtil.toJsonStr(secondNotTranslate.stream().map(ImportData::getSecondName).collect(Collectors.toList())));
                Logger.info("品牌未翻译: {}", JSONUtil.toJsonStr(brandNotTranslate));
                Logger.info("ark 兜底配置: {}", config);

            }
        }).sheet(0).doRead();

    }

    @Test
    public void test1() throws Exception {
        getSeriesTranslateData();
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
        }).sheet(1).doRead();

        Map<Integer, List<BrandClassTranslateData>> map = list.stream().collect(Collectors.groupingBy(BrandClassTranslateData::getSecondId));
        System.out.println("品牌: " + JSONUtil.toJsonStr(map));
        return map;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ImportData {

        @ExcelProperty(index = 1)
        private Integer secondId;

        @ExcelProperty(index = 2)
        private String secondName;

        @ExcelProperty(index = 3)
        private Integer secondPromptId;

        @ExcelProperty(index = 4)
        private String secondPromptName;

        @ExcelProperty(index = 7)
        private Integer promptId;

        @ExcelProperty(index = 8)
        private String promptInfo;
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

        @ExcelProperty(index = 1)
        private Integer secondId;

        @ExcelProperty(index = 3)
        private String name;

        @ExcelProperty(index = 4)
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
}
