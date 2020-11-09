package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        LOG.trace("trace message");
        LOG.debug("debug message");
        LOG.info("info message");
        LOG.warn("warn message");
        LOG.error("error message");
        byte byteVar = 1;
        short shortVar = 2;
        int intVar = 3;
        long longVar = 4;
        boolean boolVar = true;
        float floatVar = 1.2F;
        double doubleVar = 12.34;
        char charVar = 'A';
        LOG.debug("Variables:{}, {}, {}, {}, {}, {}, {}, {}",
                byteVar, shortVar, intVar, longVar, boolVar, charVar, floatVar, doubleVar);

    }
}