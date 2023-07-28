package com.lizza.Enum;

import org.junit.Test;

public class ParserEnumTests {

    @Test
    public void test1() throws Exception {
        for (int i = 0; i < 5; i++) {
            TableParser<User> parser = ParserEnum.parse("user");
            User user = parser.parse();
        }
    }
}
