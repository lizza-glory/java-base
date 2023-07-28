package com.lizza.Enum;

import java.util.function.Supplier;

public enum ParserEnum {

    USER_PARSER("user", new Supplier<TableParser<?>>() {
        @Override
        public TableParser<?> get() {
            return null;
        }
    });
    String table;
    Supplier<TableParser<?>> supplier;

    ParserEnum(String table, Supplier<TableParser<?>> supplier) {
        this.table = table;
        this.supplier = supplier;
    }

    @SuppressWarnings("unchecked")
    public static <T> T parse(String table) {
        TableParser<T> parser = null;
        for (ParserEnum value : ParserEnum.values()) {
            if (value.table.equals(table)) {
                parser = (TableParser<T>) value.supplier.get();
                break;
            }
        }

        return parser.parse();
    }
}