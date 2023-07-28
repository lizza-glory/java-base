package com.lizza.Collectors;

public enum Season {

    SPRING("spring", "春天", 1),
    SUMMER("summer", "夏天", 1),
    AUTUMN("autumn", "秋天", 1),
    WINTER("winter", "冬天", 1);

    private String name;
    private String desc;
    private Integer value;

    Season(String name, String desc, Integer value) {
        this.name = name;
        this.desc = desc;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public Integer getValue() {
        return value;
    }
}
