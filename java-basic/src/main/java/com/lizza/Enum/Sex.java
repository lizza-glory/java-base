package com.lizza.Enum;

public enum Sex {
    MALE("male"){
        @Override
        public String desc(String prefix) {
            return prefix + ": 男";
        }
    },
    FEMALE("female") {
        @Override
        public String desc(String prefix) {
            return prefix + ": 女";
        }
    };
    public String sex;
    Sex(String sex) {
        this.sex = sex;
    }
    public abstract String desc(String prefix);
}
